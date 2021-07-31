package com.free.freevideostreamingapi.repository;

import com.free.freevideostreamingapi.entity.Library;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LibraryRepository extends CassandraRepository<Library, UUID> {
}
