package com.yutech.yutechvideostreamingapi.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

@RestController
public class VideoController {

    @Autowired
    VideoRepository videoRepository;

    @Autowired
    VideoReactiveRepository videoReactiveRepository;

    @PostMapping(value = "/api/v1/videos")
    public VideoDto postVideo(@Valid @RequestBody VideoDto videoDto) {
        Video video = new Video();
        video.setId(UUID.randomUUID().toString());
        video.setTitle(videoDto.getTitle());
        video.setDescription(videoDto.getDescription());
        video.setExternalUrl(videoDto.getExternalUrl());
        video.setLocation(videoDto.getLocation());
        video.setVideoStats(new VideoStats());
        video.getVideoStats().setDislikesNum(0);
        video.getVideoStats().setLikesNum(0);
        video.getVideoStats().setTotalViewsNumber(0);
        video = videoRepository.save(video);
        videoDto.setVideoStats(video.getVideoStats());
        videoDto.setId(video.getId());
        return videoDto;
    }

    @PutMapping(value = "/api/v1/videos")
    public VideoDto putVideo(@Valid @RequestBody VideoDto videoDto) {
        Video video = new Video();
        video.setId(videoDto.getId());
        video.setTitle(videoDto.getTitle());
        video.setDescription(videoDto.getDescription());
        video.setExternalUrl(videoDto.getExternalUrl());
        video.setLocation(videoDto.getLocation());
        video.setVideoStats(new VideoStats());
        video.getVideoStats().setDislikesNum(0);
        video.getVideoStats().setLikesNum(0);
        video.getVideoStats().setTotalViewsNumber(0);
        videoRepository.save(video);
        return videoDto;
    }

    @GetMapping(value = "/api/v1/videos/{id}")
    public ResponseEntity<VideoDto> findVideoById(@PathVariable String id) {
        Optional<Video> opt = videoRepository.findById(id);
        if (!opt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Video video = opt.get();
        VideoDto videoDto = new VideoDto();
        videoDto.setId(video.getId());
        videoDto.setTitle(video.getTitle());
        videoDto.setLocation(video.getLocation());
        videoDto.setExternalUrl(video.getExternalUrl());
        videoDto.setVideoStats(video.getVideoStats());
        videoDto.setDescription(video.getDescription());
        return ResponseEntity.ok(videoDto);
    }

    //medlennee
    @GetMapping(value = "/api/v1/reactive/videos/{id}")
    public Mono findReactiveVideoById(@PathVariable String id) {
        return videoReactiveRepository.findById(id)
                .map(x -> ResponseEntity.ok(x))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/api/v1/videos/{id}")
    public void deleteVideo(@PathVariable String id) {
        videoRepository.deleteById(id);
    }


}
