package com.free.freevideostreamingapi.service;

import com.free.freevideostreamingapi.entity.User;
import com.free.freevideostreamingapi.repository.UserRepository;
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

        User user1 = userRepository.findByEmail(username);
        User user2 = userRepository.findByUsername(username);
        if (user1 == null && user2 == null) {
            throw new UsernameNotFoundException("Username not found");
        }

        if (user1 != null){
            return user1;
        }

        return user2;
    }

}
