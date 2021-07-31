package com.free.freevideostreamingapi.repository;

import com.free.freevideostreamingapi.entity.User;
import com.free.freevideostreamingapi.repository.UserRepository;
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
