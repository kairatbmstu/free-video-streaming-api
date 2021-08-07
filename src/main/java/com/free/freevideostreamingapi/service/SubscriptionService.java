package com.free.freevideostreamingapi.service;


import com.free.freevideostreamingapi.application.dto.ChannelDto;
import com.free.freevideostreamingapi.application.dto.SubscriptionDto;
import com.free.freevideostreamingapi.infrastucture.entity.ChannelEntity;
import com.free.freevideostreamingapi.infrastucture.entity.SubscriptionEntity;
import com.free.freevideostreamingapi.infrastucture.repository.ChannelRepository;
import com.free.freevideostreamingapi.infrastucture.repository.SubscriptionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    ChannelRepository channelRepository;


    public List<ChannelDto> getSubsribeChannels(String userId) {
        List<SubscriptionEntity> subsribes = subscriptionRepository.findChannelsByUserId(userId);
        List<String> channelIds = subsribes.stream().map(x -> x.getChannelId()).collect(Collectors.toList());
        List<ChannelEntity> channelList = channelRepository.findAllById(channelIds);
        return channelList
                .stream()
                .map(x -> new ChannelDto(x.getId(), x.getTitle(), x.getDescription(), x.getSubsribersNum()))
                .collect(Collectors.toList());
    }

    public void subsribeOnChannel(SubscriptionDto subscriptionDto) {
        List<SubscriptionEntity> subscriptions = subscriptionRepository.findByUserIdAndChannelId(subscriptionDto.getUserId(), subscriptionDto.getChannelId());
        if (subscriptions.isEmpty()) {
            SubscriptionEntity subscription = new SubscriptionEntity();
            subscription.setChannelId(subscriptionDto.getChannelId());
            subscription.setUserId(subscriptionDto.getUserId());
            subscription.setSubscribeDatetime(LocalDateTime.now());
            subscriptionRepository.save(subscription);
        }
    }

    public void unsubsribeFromChannel(SubscriptionDto subscriptionDto) {
        List<SubscriptionEntity> subscriptions = subscriptionRepository.findByUserIdAndChannelId(subscriptionDto.getUserId(), subscriptionDto.getChannelId());
        subscriptionRepository.deleteAll(subscriptions);
    }

}
