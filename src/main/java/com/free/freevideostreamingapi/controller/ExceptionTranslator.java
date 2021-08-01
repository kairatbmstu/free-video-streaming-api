package com.free.freevideostreamingapi.controller;

import com.free.freevideostreamingapi.exception.DefaultErrorDto;
import com.free.freevideostreamingapi.exception.DefaultException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionTranslator {

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity handle(UsernameNotFoundException usernameNotFoundException){
        log.error(usernameNotFoundException.getMessage(),usernameNotFoundException);
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(value = DefaultException.class)
    public ResponseEntity handle(DefaultException defex){
        log.error(defex.getMessage(),defex);
        return ResponseEntity.status(500).body(new DefaultErrorDto(defex.getCode(),defex.getMessage()));
    }


}
