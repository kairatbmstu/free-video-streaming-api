package com.yutech.yutechvideostreamingapi.oauth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionTranslator {

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity handle(UsernameNotFoundException usernameNotFoundException){
        usernameNotFoundException.printStackTrace();
        return ResponseEntity.notFound().build();
    }

}
