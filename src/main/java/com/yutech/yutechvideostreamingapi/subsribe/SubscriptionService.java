package com.yutech.yutechvideostreamingapi.subsribe;


import com.yutech.yutechvideostreamingapi.channel.Channel;
import com.yutech.yutechvideostreamingapi.channel.ChannelDto;
import com.yutech.yutechvideostreamingapi.channel.ChannelRepository;
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
        List<Subscription> subsribes = subscriptionRepository.findChannelsByUserId(userId);
        List<String> channelIds = subsribes.stream().map(x -> x.getChannelId()).collect(Collectors.toList());
        List<Channel> channelList = channelRepository.findAllById(channelIds);
        return channelList
                .stream()
                .map(x -> new ChannelDto(x.getId(), x.getTitle(), x.getDescription(), x.getSubsribersNum()))
                .collect(Collectors.toList());
    }

    public void subsribeOnChannel(SubscriptionDto subscriptionDto) {
        List<Subscription> subscriptions = subscriptionRepository.findByUserIdAndChannelId(subscriptionDto.getUserId(), subscriptionDto.getChannelId());
        if (subscriptions.isEmpty()) {
            Subscription subscription = new Subscription();
            subscription.setChannelId(subscriptionDto.getChannelId());
            subscription.setUserId(subscriptionDto.getUserId());
            subscription.setSubscribeDatetime(LocalDateTime.now());
            subscriptionRepository.save(subscription);
        }
    }

    public void unsubsribeFromChannel(SubscriptionDto subscriptionDto) {
        List<Subscription> subscriptions = subscriptionRepository.findByUserIdAndChannelId(subscriptionDto.getUserId(), subscriptionDto.getChannelId());
        subscriptionRepository.deleteAll(subscriptions);
    }

}
