package com.free.freevideostreamingapi.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailAlreadyExists extends RuntimeException {

    String code = "email_already_exists";

    String message = "Email Already Exists";

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
