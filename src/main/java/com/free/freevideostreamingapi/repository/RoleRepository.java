package com.free.freevideostreamingapi.repository;

import com.free.freevideostreamingapi.entity.Role;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CassandraRepository<Role, String> {

}
