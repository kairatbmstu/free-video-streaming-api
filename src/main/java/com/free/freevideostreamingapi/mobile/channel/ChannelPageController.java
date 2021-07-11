package com.free.freevideostreamingapi.mobile.channel;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/mobile")
public class ChannelPageController {

    @GetMapping
    public ChannelPage getChannelPage(){
        return new ChannelPage();
    }

}
