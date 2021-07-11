package com.yutech.yutechvideostreamingapi.web.channel;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/web")
public class ChannelPageController {

    @GetMapping
    public ChannelPage getChannelPage(){
        return new ChannelPage();
    }

}
