package com.free.freevideostreamingapi.infrastructure.repository;

import com.free.freevideostreamingapi.domain.model.Video;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoReactiveRepository extends ReactiveCassandraRepository<Video, String> {


}
