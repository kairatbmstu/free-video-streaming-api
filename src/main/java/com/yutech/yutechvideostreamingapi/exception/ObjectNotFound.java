package com.yutech.yutechvideostreamingapi.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObjectNotFound extends RuntimeException {

    String code = "object_not_found";

    String message = "Object not found";

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
