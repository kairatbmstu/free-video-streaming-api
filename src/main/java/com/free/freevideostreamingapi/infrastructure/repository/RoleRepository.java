package com.free.freevideostreamingapi.infrastructure.repository;

import com.free.freevideostreamingapi.domain.model.Role;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CassandraRepository<Role, String> {

}
