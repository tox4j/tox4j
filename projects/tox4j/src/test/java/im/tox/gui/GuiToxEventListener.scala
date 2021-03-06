package im.tox.gui

import javax.swing._

import im.tox.tox4j.ToxCoreTestBase.readablePublicKey
import im.tox.tox4j.core.callbacks.ToxEventListener
import im.tox.tox4j.core.enums.{ToxConnection, ToxFileControl, ToxMessageType, ToxUserStatus}
import org.jetbrains.annotations.NotNull

final class GuiToxEventListener(toxGui: MainView) extends ToxEventListener[Unit] {

  private def addMessage(method: String, args: Any*): Unit = {
    val str = new StringBuilder
    str.append(method)
    str.append('(')
    var first = true
    for (arg <- args) {
      if (!first) {
        str.append(", ")
      }
      str.append(arg)
      first = false
    }
    str.append(')')
    toxGui.addMessage(str.toString())
  }

  override def selfConnectionStatus(@NotNull connectionStatus: ToxConnection)(state: Unit): Unit = {
    addMessage("selfConnectionStatus", connectionStatus)
  }

  override def fileRecvControl(friendNumber: Int, fileNumber: Int, @NotNull control: ToxFileControl)(state: Unit): Unit = {
    addMessage("fileRecvControl", friendNumber, fileNumber, control)

    try {
      control match {
        case ToxFileControl.RESUME =>
          toxGui.fileModel.get(friendNumber, fileNumber).resume()
        case ToxFileControl.CANCEL =>
          throw new UnsupportedOperationException("CANCEL")
        case ToxFileControl.PAUSE =>
          throw new UnsupportedOperationException("PAUSE")
      }
    } catch {
      case e: Throwable =>
        JOptionPane.showMessageDialog(toxGui, MainView.printExn(e))
    }
  }

  override def fileRecv(friendNumber: Int, fileNumber: Int, kind: Int, fileSize: Long, @NotNull filename: Array[Byte])(state: Unit): Unit = {
    addMessage("fileRecv", friendNumber, fileNumber, kind, fileSize, new String(filename))

    try {
      val confirmation = JOptionPane.showConfirmDialog(toxGui, "Incoming file transfer: " + new String(filename))

      val cancel =
        if (confirmation == JOptionPane.OK_OPTION) {
          val chooser = new JFileChooser
          val returnVal = chooser.showOpenDialog(toxGui)

          if (returnVal == JFileChooser.APPROVE_OPTION) {
            toxGui.fileModel.addIncoming(friendNumber, fileNumber, kind, fileSize, chooser.getSelectedFile)
            toxGui.tox.fileControl(friendNumber, fileNumber, ToxFileControl.RESUME)
            true
          } else {
            false
          }
        } else {
          false
        }

      if (cancel) {
        toxGui.tox.fileControl(friendNumber, fileNumber, ToxFileControl.CANCEL)
      }
    } catch {
      case e: Throwable =>
        JOptionPane.showMessageDialog(toxGui, MainView.printExn(e))
    }
  }

  override def fileRecvChunk(friendNumber: Int, fileNumber: Int, position: Long, @NotNull data: Array[Byte])(state: Unit): Unit = {
    addMessage("fileRecvChunk", friendNumber, fileNumber, position, "byte[" + data.length + ']')
    try {
      toxGui.fileModel.get(friendNumber, fileNumber).write(position, data)
    } catch {
      case e: Throwable =>
        JOptionPane.showMessageDialog(toxGui, MainView.printExn(e))
    }
  }

  override def fileChunkRequest(friendNumber: Int, fileNumber: Int, position: Long, length: Int)(state: Unit): Unit = {
    addMessage("fileChunkRequest", friendNumber, fileNumber, position, length)
    try {
      if (length == 0) {
        toxGui.fileModel.remove(friendNumber, fileNumber)
      } else {
        toxGui.tox.fileSendChunk(friendNumber, fileNumber, position, toxGui.fileModel.get(friendNumber, fileNumber).read(position, length))
      }
    } catch {
      case e: Throwable =>
        JOptionPane.showMessageDialog(toxGui, MainView.printExn(e))
    }
  }

  override def friendConnectionStatus(friendNumber: Int, @NotNull connectionStatus: ToxConnection)(state: Unit): Unit = {
    addMessage("friendConnectionStatus", friendNumber, connectionStatus)
    toxGui.friendListModel.setConnectionStatus(friendNumber, connectionStatus)
  }

  override def friendLosslessPacket(friendNumber: Int, @NotNull data: Array[Byte])(state: Unit): Unit = {
    addMessage("friendLosslessPacket", friendNumber, readablePublicKey(data))
  }

  override def friendLossyPacket(friendNumber: Int, @NotNull data: Array[Byte])(state: Unit): Unit = {
    addMessage("friendLossyPacket", friendNumber, readablePublicKey(data))
  }

  override def friendMessage(friendNumber: Int, @NotNull messageType: ToxMessageType, timeDelta: Int, @NotNull message: Array[Byte])(state: Unit): Unit = {
    addMessage("friendMessage", friendNumber, messageType, timeDelta, new String(message))
  }

  override def friendName(friendNumber: Int, @NotNull name: Array[Byte])(state: Unit): Unit = {
    addMessage("friendName", friendNumber, new String(name))
    toxGui.friendListModel.setName(friendNumber, new String(name))
  }

  override def friendRequest(@NotNull publicKey: Array[Byte], timeDelta: Int, @NotNull message: Array[Byte])(state: Unit): Unit = {
    addMessage("friendRequest", readablePublicKey(publicKey), timeDelta, new String(message))
  }

  override def friendStatus(friendNumber: Int, @NotNull status: ToxUserStatus)(state: Unit): Unit = {
    addMessage("friendStatus", friendNumber, status)
    toxGui.friendListModel.setStatus(friendNumber, status)
  }

  override def friendStatusMessage(friendNumber: Int, @NotNull message: Array[Byte])(state: Unit): Unit = {
    addMessage("friendStatusMessage", friendNumber, new String(message))
    toxGui.friendListModel.setStatusMessage(friendNumber, new String(message))
  }

  override def friendTyping(friendNumber: Int, isTyping: Boolean)(state: Unit): Unit = {
    addMessage("friendTyping", friendNumber, isTyping)
    toxGui.friendListModel.setTyping(friendNumber, isTyping)
  }

  override def friendReadReceipt(friendNumber: Int, messageId: Int)(state: Unit): Unit = {
    addMessage("friendReadReceipt", friendNumber, messageId)
  }
}
