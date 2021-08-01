package com.free.freevideostreamingapi.exception;

public class UsernameAlreadyExists extends DefaultException  {

    String code = "username_already_exists";

    String message = "Username is Already Exists";

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
