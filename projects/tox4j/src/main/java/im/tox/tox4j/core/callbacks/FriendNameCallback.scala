package im.tox.tox4j.core.callbacks

import org.jetbrains.annotations.NotNull

/**
 * This event is triggered when a friend changes their name.
 */
trait FriendNameCallback[ToxCoreState] {
  /**
   * @param friendNumber The friend number of the friend whose name changed.
   * @param name The new nickname.
   */
  def friendName(
    friendNumber: Int, @NotNull name: Array[Byte]
  )(state: ToxCoreState): ToxCoreState = state
}
