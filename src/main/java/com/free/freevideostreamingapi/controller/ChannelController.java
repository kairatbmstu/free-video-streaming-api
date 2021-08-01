package com.free.freevideostreamingapi.controller;


import com.free.freevideostreamingapi.dto.VideoDto;
import com.free.freevideostreamingapi.entity.Channel;
import com.free.freevideostreamingapi.dto.ChannelDto;
import com.free.freevideostreamingapi.repository.ChannelRepository;
import com.free.freevideostreamingapi.repository.VideoRepository;
import com.free.freevideostreamingapi.exception.ObjectNotFound;
import com.free.freevideostreamingapi.repository.SubscriptionRepository;
import com.free.freevideostreamingapi.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController("/api/v1")
public class ChannelController {

    @Autowired
    ChannelService channelService;

    @GetMapping("/channels/{id}")
    public ChannelDto getChannel(@PathVariable String id) {
        return channelService.getChannel(id);
    }

    @GetMapping("/channels/{channelId}/videos}")
    public List<VideoDto> getChannelVideos(@PathVariable String channelId, @RequestParam int offset, @RequestParam int limit){
        return channelService.getChannelVideos(channelId, offset, limit);
    }

}
