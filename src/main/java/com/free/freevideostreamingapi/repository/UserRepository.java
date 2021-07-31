package com.free.freevideostreamingapi.repository;


import com.free.freevideostreamingapi.entity.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CassandraRepository<User, String> {

    @Query("select * from user where username = :username ALLOW FILTERING")
    List<User> findByUsername(@Param("username") String username);

    @Query("select * from user where email = :email ALLOW FILTERING")
    User findByEmail(@Param("email") String email);

}
