package im.tox.tox4j.av;

import im.tox.tox4j.ToxCoreTestBase;
import im.tox.tox4j.av.exceptions.ToxAvNewException;
import im.tox.tox4j.core.ToxCore;
import im.tox.tox4j.core.enums.ToxProxyType;
import im.tox.tox4j.core.exceptions.ToxNewException;
import im.tox.tox4j.core.options.ProxyOptions;
import im.tox.tox4j.core.options.ToxOptions;

public abstract class ToxAvTestBase extends ToxCoreTestBase {

  protected abstract ToxAv newToxAv(ToxCore tox) throws ToxAvNewException;

  protected final ToxAv newToxAv() throws ToxNewException, ToxAvNewException {
    return newToxAv(newTox());
  }

  protected final ToxAv newToxAv(byte[] data) throws ToxNewException, ToxAvNewException {
    return newToxAv(newTox(data));
  }

  protected final ToxAv newToxAv(ToxOptions options) throws ToxNewException, ToxAvNewException {
    return newToxAv(newTox(options));
  }

  protected final ToxAv newToxAv(boolean ipv6Enabled, boolean udpEnabled) throws ToxNewException, ToxAvNewException {
    return newToxAv(newTox(ipv6Enabled, udpEnabled));
  }

  protected final ToxAv newToxAv(boolean ipv6Enabled, boolean udpEnabled, ProxyOptions.Type proxy)
      throws ToxNewException, ToxAvNewException {
    return newToxAv(newTox(ipv6Enabled, udpEnabled, proxy));
  }

}
