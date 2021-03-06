package com.free.freevideostreamingapi.service;

import com.free.freevideostreamingapi.dto.VideoDto;
import com.free.freevideostreamingapi.entity.Video;
import com.free.freevideostreamingapi.entity.VideoStats;
import com.free.freevideostreamingapi.repository.VideoReactiveRepository;
import com.free.freevideostreamingapi.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Service
public class VideoService {

    @Autowired
    VideoRepository videoRepository;

    @Autowired
    VideoReactiveRepository videoReactiveRepository;

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

    public void deleteVideo(@PathVariable String id) {
        videoRepository.deleteById(id);
    }

}
