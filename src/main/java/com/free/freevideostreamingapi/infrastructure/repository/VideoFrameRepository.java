package com.free.freevideostreamingapi.infrastructure.repository;

import com.free.freevideostreamingapi.domain.model.VideoFrame;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoFrameRepository extends CassandraRepository<VideoFrame, String> {


}
