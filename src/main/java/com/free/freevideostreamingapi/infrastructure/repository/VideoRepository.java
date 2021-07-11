package com.free.freevideostreamingapi.infrastructure.repository;


import com.free.freevideostreamingapi.domain.model.Video;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VideoRepository extends CassandraRepository<Video, String> {


    List<Video> findByChannelId(String channelId);

}
