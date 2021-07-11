package com.free.freevideostreamingapi.oauth.controller;

import com.free.freevideostreamingapi.user.User;
import com.free.freevideostreamingapi.user.UserRepository;
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
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;


    @Transactional
    @PostMapping(value = "/user/registration", consumes = "application/json")
    public ResponseEntity registration(@RequestBody User userDto){
        User exists = userRepository.findByEmail(userDto.getEmail());
        if (exists != null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Email is already exists");
        }
        List<User> users = userRepository.findByUsername(userDto.getUsername());
        if (!users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Username is already exists");
        }
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        System.out.println(" user.login : " + userDto.getUsername());
        System.out.println(" pass    : " + userDto.getPassword());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        List<String> roles = new ArrayList();
        roles.add("ROLE_USER");
        user.setRoles(roles);
        user = userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/open")
    public String open(){
        return "Open";
    }


}
