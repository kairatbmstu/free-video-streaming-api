package com.free.freevideostreamingapi.controller;


import com.free.freevideostreamingapi.dto.VideoDto;
import com.free.freevideostreamingapi.entity.User;
import com.free.freevideostreamingapi.dto.ChannelDto;
import com.free.freevideostreamingapi.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @PostMapping("/channels")
    public ChannelDto postChannel(@RequestBody ChannelDto channelDto) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        channelDto.setUserId(user.getId());
        return channelService.createChannel(channelDto);
    }

    @PutMapping("/channels/{id}")
    public ChannelDto putChannel(@PathVariable String id, @RequestBody ChannelDto channelDto) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        channelDto.setUserId(user.getId());
        return channelService.updateChannel(channelDto);
    }

}
