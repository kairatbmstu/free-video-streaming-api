package com.free.freevideostreamingapi.service;

import com.free.freevideostreamingapi.infrastucture.entity.UserEntity;
import com.free.freevideostreamingapi.infrastucture.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("login by : " + username);

        UserEntity user1 = userRepository.findByEmail(username);
        UserEntity user2 = userRepository.findByUsername(username);
        if (user1 == null && user2 == null) {
            throw new UsernameNotFoundException("username or email is not found");
        }

        if (user1 != null){
            return user1;
        }

        return user2;
    }

}
