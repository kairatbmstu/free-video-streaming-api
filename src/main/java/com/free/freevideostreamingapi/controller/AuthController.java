package com.free.freevideostreamingapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/open")
@RestController
public class AuthController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello";
    }

    @GetMapping("/helloProtected")
    @ResponseBody
    public String helloProtected() {
        return "Hello protected";
    }

}
