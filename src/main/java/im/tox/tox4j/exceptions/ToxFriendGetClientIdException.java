package im.tox.tox4j.exceptions;

import im.tox.tox4j.annotations.NotNull;

public final class ToxFriendGetClientIdException extends ToxException {

    public static enum Code {
        FRIEND_NOT_FOUND,
    }

    private final Code code;

    public ToxFriendGetClientIdException(Code code) {
        this.code = code;
    }

    @NotNull
    @Override
    public Code getCode() {
        return code;
    }

}
