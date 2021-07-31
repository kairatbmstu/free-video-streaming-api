package com.free.freevideostreamingapi.controller;

import com.free.freevideostreamingapi.entity.User;
import com.free.freevideostreamingapi.repository.UserRepository;
import com.free.freevideostreamingapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/oauth")
@RestController
public class UserController {

    @Autowired
    UserService userService;


    @Transactional
    @PostMapping(value = "/user/registration", consumes = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void registration(@RequestBody User userDto){
         userService.registration(userDto);
    }

    @GetMapping("/open")
    public String open(){
        return "Open";
    }


}
