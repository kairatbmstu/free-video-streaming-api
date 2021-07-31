package com.free.freevideostreamingapi.repository;


import com.free.freevideostreamingapi.entity.Channel;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends CassandraRepository<Channel, String> {
}
