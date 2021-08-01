package com.free.freevideostreamingapi.exception;

public abstract class DefaultException extends RuntimeException {

    public abstract String getCode();

    public abstract void setCode(String code);

    public abstract String getMessage();

    public abstract void setMessage(String message);
}
