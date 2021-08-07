package com.free.freevideostreamingapi.infrastucture.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import com.free.freevideostreamingapi.infrastucture.entity.LibraryEntity;

@Repository
public interface LibraryRepository extends CassandraRepository<LibraryEntity, UUID> {
}
