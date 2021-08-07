package com.free.freevideostreamingapi.infrastucture.repository;

import com.free.freevideostreamingapi.infrastucture.entity.VideoFileEntity;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoFileRepository extends CassandraRepository<VideoFileEntity,String> {
}
