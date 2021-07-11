package com.yutech.yutechvideostreamingapi.video;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoFrameRepository extends CassandraRepository<VideoFrame, String> {


}
