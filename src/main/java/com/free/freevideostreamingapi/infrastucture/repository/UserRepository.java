package com.free.freevideostreamingapi.infrastucture.repository;


import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.free.freevideostreamingapi.infrastucture.entity.UserEntity;

@Repository
public interface UserRepository extends CassandraRepository<UserEntity, String> {

    @Query("select * from user where username = :username ALLOW FILTERING")
    UserEntity findByUsername(@Param("username") String username);

    @Query("select * from user where email = :email ALLOW FILTERING")
    UserEntity findByEmail(@Param("email") String email);

}
