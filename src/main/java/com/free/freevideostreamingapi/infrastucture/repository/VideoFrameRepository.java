package com.free.freevideostreamingapi.infrastucture.repository;

import com.free.freevideostreamingapi.infrastucture.entity.VideoFrameEntity;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoFrameRepository extends CassandraRepository<VideoFrameEntity, String> {


}
