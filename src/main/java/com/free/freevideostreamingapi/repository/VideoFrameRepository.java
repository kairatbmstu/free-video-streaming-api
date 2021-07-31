package com.free.freevideostreamingapi.repository;

import com.free.freevideostreamingapi.entity.VideoFrame;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoFrameRepository extends CassandraRepository<VideoFrame, String> {


}
