package com.free.freevideostreamingapi.infrastructure.repository;


import com.free.freevideostreamingapi.domain.model.Channel;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends CassandraRepository<Channel, String> {
}
