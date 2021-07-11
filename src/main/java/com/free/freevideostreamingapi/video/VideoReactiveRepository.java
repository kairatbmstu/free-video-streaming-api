package com.free.freevideostreamingapi.video;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoReactiveRepository extends ReactiveCassandraRepository<Video, String> {


}
