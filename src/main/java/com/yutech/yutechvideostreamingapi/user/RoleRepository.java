package com.yutech.yutechvideostreamingapi.user;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CassandraRepository<Role, String> {

}
