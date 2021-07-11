package com.free.freevideostreamingapi.infrastructure.repository;

import com.free.freevideostreamingapi.domain.model.VideoFile;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoFileRepository extends CassandraRepository<VideoFile,String> {
}
