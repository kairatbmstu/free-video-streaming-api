package com.yutech.yutechvideostreamingapi.channel;


import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChannelRepository extends CassandraRepository<Channel, String> {
}
