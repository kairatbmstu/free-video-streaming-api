package com.free.freevideostreamingapi.oauth.dao;

import com.free.freevideostreamingapi.user.User;
import com.free.freevideostreamingapi.user.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Repository
@RequiredArgsConstructor
public class UserDao {

    private final UserRepository userRepository;

    @Transactional
    public User create(@NonNull User entity) {
        return userRepository.save(entity);
    }

    @Transactional(readOnly = true)
    public User find(@NonNull String id) throws UserPrincipalNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserPrincipalNotFoundException("User not found - " ));
    }

    @Transactional
    public void update(@NonNull User processed) {
        userRepository.save(processed);
    }

}
