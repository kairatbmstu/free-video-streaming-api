package com.yutech.yutechvideostreamingapi.web.video;

import com.yutech.yutechvideostreamingapi.web.playlist.PlaylistVideoPage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class VideoPageController {

    @GetMapping("/video-page")
    public VideoPage getVideoPage() {
        return new VideoPage();
    }



}
