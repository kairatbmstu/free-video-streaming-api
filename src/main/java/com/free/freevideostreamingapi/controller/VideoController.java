package com.free.freevideostreamingapi.controller;

import com.free.freevideostreamingapi.dto.VideoDto;
import com.free.freevideostreamingapi.entity.Video;
import com.free.freevideostreamingapi.entity.VideoStats;
import com.free.freevideostreamingapi.repository.VideoReactiveRepository;
import com.free.freevideostreamingapi.repository.VideoRepository;
import com.free.freevideostreamingapi.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
public class VideoController {

    @Autowired
    VideoService videoService;

    @PostMapping(value = "/api/v1/videos")
    public VideoDto postVideo(@Valid @RequestBody VideoDto videoDto) {
        return videoService.postVideo(videoDto);
    }

    @PutMapping(value = "/api/v1/videos")
    public VideoDto putVideo(@Valid @RequestBody VideoDto videoDto) {
        return videoService.putVideo(videoDto);
    }

    @GetMapping(value = "/api/v1/videos/{id}")
    public ResponseEntity<VideoDto> findVideoById(@PathVariable String id) {
       return videoService.findVideoById(id);
    }


    @DeleteMapping(value = "/api/v1/videos/{id}")
    public void deleteVideo(@PathVariable String id) {
        videoService.deleteVideo(id);
    }


}
