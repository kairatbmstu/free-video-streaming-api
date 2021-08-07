package com.free.freevideostreamingapi.infrastucture.repository;


import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import com.free.freevideostreamingapi.infrastucture.entity.SubscriptionEntity;

@Repository
public interface SubscriptionRepository extends CassandraRepository<SubscriptionEntity, UUID> {

    List<SubscriptionEntity> findUsersByChannelId(String channelId);

    int countUsersByChannelId(String channelId);

    List<SubscriptionEntity> findChannelsByUserId(String userId);

    List<SubscriptionEntity> findByUserIdAndChannelId(String userId, String channelId);

}
