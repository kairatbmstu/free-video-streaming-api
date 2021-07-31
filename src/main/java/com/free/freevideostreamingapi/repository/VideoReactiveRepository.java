package com.free.freevideostreamingapi.repository;

import com.free.freevideostreamingapi.entity.Video;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoReactiveRepository extends ReactiveCassandraRepository<Video, String> {


}
