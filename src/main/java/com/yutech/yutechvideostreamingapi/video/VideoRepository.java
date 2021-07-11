package com.yutech.yutechvideostreamingapi.video;


import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface VideoRepository extends CassandraRepository<Video, String> {


    List<Video> findByChannelId(String channelId);

}
