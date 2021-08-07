package com.free.freevideostreamingapi.infrastucture.repository;

import com.free.freevideostreamingapi.infrastucture.entity.RoleEntity;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CassandraRepository<RoleEntity, String> {

}
