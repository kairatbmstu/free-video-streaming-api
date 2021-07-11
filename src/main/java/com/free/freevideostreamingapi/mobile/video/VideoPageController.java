package com.free.freevideostreamingapi.mobile.video;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/mobile")
@RestController("MobileVideoPageController")
public class VideoPageController {

    @GetMapping("/video-page")
    public VideoPage getVideoPage() {
        return new VideoPage();
    }



}
