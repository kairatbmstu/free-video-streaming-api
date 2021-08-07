package com.free.freevideostreamingapi.service;

import com.free.freevideostreamingapi.exception.EmailAlreadyExists;
import com.free.freevideostreamingapi.exception.UsernameAlreadyExists;
import com.free.freevideostreamingapi.infrastucture.entity.UserEntity;
import com.free.freevideostreamingapi.infrastucture.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;


    @Transactional
    public void registration(@RequestBody UserEntity userDto){
        UserEntity exists = userRepository.findByEmail(userDto.getEmail());
        if (exists != null) {
            throw new EmailAlreadyExists();
        }
        UserEntity userByUsername = userRepository.findByUsername(userDto.getUsername());
        if (userByUsername != null) {
            throw new UsernameAlreadyExists();
        }
        UserEntity user = new UserEntity();
        user.setId(UUID.randomUUID().toString());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        System.out.println(" user.login : " + userDto.getUsername());
        System.out.println(" pass    : " + userDto.getPassword());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        List<String> roles = new ArrayList();
        roles.add("ROLE_USER");
        user.setRoles(roles);
        userRepository.save(user);
    }

}
