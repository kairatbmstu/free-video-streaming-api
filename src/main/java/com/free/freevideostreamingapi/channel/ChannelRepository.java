package com.free.freevideostreamingapi.channel;


import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends CassandraRepository<Channel, String> {
}
