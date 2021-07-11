package com.free.freevideostreamingapi.oauth.service.impl;

import com.free.freevideostreamingapi.user.UserRepository;
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
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("email : " + email);
        if (userRepository.findByEmail(email) == null){
            throw new UsernameNotFoundException("Username not found");
        }
        return userRepository.findByEmail(email);
    }

}
