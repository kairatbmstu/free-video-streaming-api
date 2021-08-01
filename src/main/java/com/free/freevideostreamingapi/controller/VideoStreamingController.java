package com.free.freevideostreamingapi.controller;

import com.free.freevideostreamingapi.entity.Video;
import com.free.freevideostreamingapi.entity.VideoFile;
import com.free.freevideostreamingapi.exception.ObjectNotFound;
import com.free.freevideostreamingapi.repository.VideoFileRepository;
import com.free.freevideostreamingapi.repository.VideoRepository;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RestController
public class VideoStreamingController {

    @Autowired
    VideoRepository videoRepository;

    @Autowired
    VideoFileRepository videoFileRepository;

    @GetMapping("/api/v1/video-streaming/{id}/media.m3u8")
    public ResponseEntity getVideoMediam3u8File(@PathVariable String id) throws IOException {
        Optional<VideoFile> videoOptional = videoFileRepository.findById(id);
        if (!videoOptional.isPresent()) {
            throw new ObjectNotFound();
        }

        VideoFile videoFile = videoOptional.get();
        byte[] bytes = FileUtils.readFileToByteArray(new File(videoFile.getOutputDir()+"/"+videoFile.getId()+"/media.m3u8"));
        return ResponseEntity.ok().body(bytes);
    }

    @GetMapping("/api/v1/video-streaming/{id}/{filename}")
    public void getVideoStreamingM3u8(@PathVariable String id, @PathVariable String filename, HttpServletResponse httpServletResponse) throws IOException {
        Optional<VideoFile> videoOptional = videoFileRepository.findById(id);
        if (!videoOptional.isPresent()) {
            throw new ObjectNotFound();
        }

        VideoFile videoFile = videoOptional.get();
        byte[] bytes = FileUtils.readFileToByteArray(new File(videoFile.getOutputDir()+"/"+videoFile.getId()+"/"+filename));
        if (StringUtils.contains(filename,".ts")){
            httpServletResponse.addHeader("Content-Type", "video/mp2t");
        }
        httpServletResponse.getOutputStream().write(bytes);
    }

}
