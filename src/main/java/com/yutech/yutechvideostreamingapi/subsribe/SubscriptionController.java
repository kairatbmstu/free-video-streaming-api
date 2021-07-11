package com.yutech.yutechvideostreamingapi.subsribe;


import com.yutech.yutechvideostreamingapi.channel.ChannelDto;
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
