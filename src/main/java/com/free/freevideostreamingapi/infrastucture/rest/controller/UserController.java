package com.free.freevideostreamingapi.infrastucture.rest.controller;

import com.free.freevideostreamingapi.infrastucture.entity.UserEntity;
import com.free.freevideostreamingapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/oauth")
@RestController
public class UserController {

    @Autowired
    UserService userService;


    @Transactional
    @PostMapping(value = "/user/registration", consumes = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void registration(@RequestBody UserEntity userDto){
         userService.registration(userDto);
    }

    @GetMapping("/open")
    public String open(){
        return "Open";
    }


}
