package com.free.freevideostreamingapi.infrastucture.repository;


import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.free.freevideostreamingapi.infrastucture.entity.VideoEntity;


@Repository
public interface VideoRepository extends CassandraRepository<VideoEntity, String> {


    List<VideoEntity> findByChannelId(String channelId);

}
