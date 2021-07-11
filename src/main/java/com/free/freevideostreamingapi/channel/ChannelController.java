package com.free.freevideostreamingapi.channel;


import com.free.freevideostreamingapi.application.dto.VideoDto;
import com.free.freevideostreamingapi.infrastructure.repository.VideoRepository;
import com.free.freevideostreamingapi.exception.ObjectNotFound;
import com.free.freevideostreamingapi.infrastructure.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController("/api/v1")
public class ChannelController {

    @Autowired
    ChannelRepository channelRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    VideoRepository videoRepository;

    @GetMapping("/channels/{id}")
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

    @GetMapping("/channels/{channelId}/videos}")
    public List<VideoDto> getChannelVideos(@PathVariable String channelId, @RequestParam int offset, @RequestParam int limit){
        List<VideoDto> videoDtos = new ArrayList<>();
        videoRepository.findByChannelId(channelId);
        return videoDtos;
    }

}
