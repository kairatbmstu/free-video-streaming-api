package com.free.freevideostreamingapi.infrastucture.rest.controller;


import com.free.freevideostreamingapi.application.dto.ChannelDto;
import com.free.freevideostreamingapi.application.dto.VideoDto;
import com.free.freevideostreamingapi.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
