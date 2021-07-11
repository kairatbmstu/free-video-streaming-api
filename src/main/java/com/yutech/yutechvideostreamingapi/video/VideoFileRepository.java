package com.yutech.yutechvideostreamingapi.video;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoFileRepository extends CassandraRepository<VideoFile,String> {
}
