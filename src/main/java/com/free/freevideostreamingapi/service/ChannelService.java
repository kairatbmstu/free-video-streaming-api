package com.free.freevideostreamingapi.service;


import com.free.freevideostreamingapi.dto.ChannelDto;
import com.free.freevideostreamingapi.dto.VideoDto;
import com.free.freevideostreamingapi.entity.Channel;
import com.free.freevideostreamingapi.exception.ObjectNotFound;
import com.free.freevideostreamingapi.repository.ChannelRepository;
import com.free.freevideostreamingapi.repository.SubscriptionRepository;
import com.free.freevideostreamingapi.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChannelService {


    @Autowired
    ChannelRepository channelRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    VideoRepository videoRepository;

    public ChannelDto getChannel(@PathVariable String id) {
        Optional<Channel> channelOpt = channelRepository.findById(id);
        if (!channelOpt.isPresent()) {
            throw new ObjectNotFound();
        }

        Channel channel = channelOpt.get();
        ChannelDto channelDto = new ChannelDto();
        channelDto.setTitle(channel.getTitle());
        channelDto.setDescription(channel.getDescription());
        channelDto.setSubsribersNum(subscriptionRepository.countUsersByChannelId(channel.getId()));
        return channelDto;
    }

    public List<VideoDto> getChannelVideos(@PathVariable String channelId, @RequestParam int offset, @RequestParam int limit){
        List<VideoDto> videoDtos = new ArrayList<>();
        videoRepository.findByChannelId(channelId);
        return videoDtos;
    }

    public ChannelDto createChannel(ChannelDto channelDto){
        Channel channel = new Channel();
        channel.setId(channelDto.getId());
        channel.setDescription(channelDto.getDescription());
        channel.setSubsribersNum(channelDto.getSubsribersNum());
        channel.setTitle(channelDto.getTitle());
        channel.setUserId(channelDto.getUserId());
        channelRepository.save(channel);
        return channelDto;
    }

    public ChannelDto updateChannel(ChannelDto channelDto){
        Channel channel = new Channel();
        channel.setId(channelDto.getId());
        channel.setDescription(channelDto.getDescription());
        channel.setSubsribersNum(channelDto.getSubsribersNum());
        channel.setTitle(channelDto.getTitle());
        channel.setUserId(channelDto.getUserId());
        channelRepository.save(channel);
        return channelDto;
    }

}
