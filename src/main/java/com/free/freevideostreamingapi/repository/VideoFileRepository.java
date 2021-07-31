package com.free.freevideostreamingapi.repository;

import com.free.freevideostreamingapi.entity.VideoFile;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoFileRepository extends CassandraRepository<VideoFile,String> {
}
