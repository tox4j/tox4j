package im.tox.tox4j.core.callbacks

import org.jetbrains.annotations.NotNull

/**
 * This event is triggered when a custom lossless packet arrives from a friend.
 */
trait FriendLosslessPacketCallback[ToxCoreState] {
  /**
   * @param friendNumber The friend number of the friend who sent a lossless packet.
   * @param data A byte array containing the received packet data. The first byte is the packet id.
   */
  def friendLosslessPacket(
    friendNumber: Int, @NotNull data: Array[Byte]
  )(state: ToxCoreState): ToxCoreState = state
}
