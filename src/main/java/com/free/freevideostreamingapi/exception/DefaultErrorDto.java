package com.free.freevideostreamingapi.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultErrorDto {

    String code;

    String message;

    public DefaultErrorDto(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
