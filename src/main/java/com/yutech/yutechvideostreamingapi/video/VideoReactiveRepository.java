package com.yutech.yutechvideostreamingapi.video;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface VideoReactiveRepository extends ReactiveCassandraRepository<Video, String> {


}
