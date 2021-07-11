package com.free.freevideostreamingapi.infrastructure.repository;


import com.free.freevideostreamingapi.domain.model.Subscription;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SubscriptionRepository extends CassandraRepository<Subscription, UUID> {

    List<Subscription> findUsersByChannelId(String channelId);

    int countUsersByChannelId(String channelId);

    List<Subscription> findChannelsByUserId(String userId);

    List<Subscription> findByUserIdAndChannelId(String userId, String channelId);

}
