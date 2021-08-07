package com.free.freevideostreamingapi.infrastucture.repository;


import com.free.freevideostreamingapi.infrastucture.entity.ChannelEntity;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends CassandraRepository<ChannelEntity, String> {
}
