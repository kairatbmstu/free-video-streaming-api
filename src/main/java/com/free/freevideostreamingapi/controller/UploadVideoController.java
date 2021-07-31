package com.free.freevideostreamingapi.controller;


import com.free.freevideostreamingapi.entity.VideoFile;
import com.free.freevideostreamingapi.repository.VideoFileRepository;
import com.free.freevideostreamingapi.dto.VideoUploadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadVideoController {

    @Autowired
    VideoFileRepository videoFileRepository;

    @PostMapping("/api/v1/upload-video")
    public void upload(@RequestBody VideoUploadRequest videoUploadRequest) throws IOException {

        File tempDir = new File("./tmp");
        if (!tempDir.exists()) {
            tempDir.mkdirs();
        }

        String id = UUID.randomUUID().toString();
        File file = new File("./tmp/" + id);
        byte[] bytes = videoUploadRequest.getFile().getBytes();
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
        }

        VideoFile videoFile = new VideoFile();
        videoFile.setId(id);
        videoFile.setTitle(videoUploadRequest.getTitle());
        videoFile.setDescription(videoUploadRequest.getDescription());
    }

}


