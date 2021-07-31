package com.free.freevideostreamingapi.controller;


import com.free.freevideostreamingapi.dto.ChannelDto;
import com.free.freevideostreamingapi.dto.SubscriptionDto;
import com.free.freevideostreamingapi.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @GetMapping("/subscriptions/{userId}/channels")
    public List<ChannelDto> getSubsribeChannels(@PathVariable String userId) {
        return subscriptionService.getSubsribeChannels(userId);
    }

    @PostMapping("/subscriptions")
    public void subsribeOnChannel(@RequestBody SubscriptionDto subscriptionDto) {
        subscriptionService.subsribeOnChannel(subscriptionDto);
    }

    @DeleteMapping("/subscriptions")
    public void unsubsribeFromChannel(@RequestBody SubscriptionDto subscriptionDto) {
        subscriptionService.unsubsribeFromChannel(subscriptionDto);
    }

}
