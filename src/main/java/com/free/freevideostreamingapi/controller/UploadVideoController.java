package com.free.freevideostreamingapi.controller;


import com.free.freevideostreamingapi.dto.VideoUploadRequest;
import com.free.freevideostreamingapi.service.UploadVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.IOException;

@RestController
public class UploadVideoController {

    @Autowired
    UploadVideoService uploadVideoService;

    @PostMapping(value = "/api/v1/upload-video")
    public void upload(@RequestBody VideoUploadRequest videoUploadRequest) throws IOException {
        uploadVideoService.upload(videoUploadRequest);
    }

}


