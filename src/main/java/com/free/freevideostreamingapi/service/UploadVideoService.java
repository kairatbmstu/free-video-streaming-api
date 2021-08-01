package com.free.freevideostreamingapi.service;

import com.free.freevideostreamingapi.dto.VideoUploadRequest;
import com.free.freevideostreamingapi.entity.VideoFile;
import com.free.freevideostreamingapi.repository.VideoFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class UploadVideoService {

    @Autowired
    VideoFileRepository videoFileRepository;

    @Autowired
    VideoFilesConverter videoFilesConverter;

    @Transactional
    public void upload(VideoUploadRequest videoUploadRequest) throws IOException {

        File tempDir = new File("/data/video/rawdata");
        if (!tempDir.exists()) {
            tempDir.mkdirs();
        }

        String id = UUID.randomUUID().toString();
        File file = new File("/data/video/rawdata/" + id);
        byte[] bytes = videoUploadRequest.getFile().getBytes();
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
        }

        VideoFile videoFile = new VideoFile();
        videoFile.setId(id);
        videoFile.setTitle(videoUploadRequest.getTitle());
        videoFile.setDescription(videoUploadRequest.getDescription());
        videoFile.setInputDir("/data/video/rawdata/");
        videoFile.setOutputDir("/data/video/hlsdata/"+id+"/");
        videoFile.setManifestFile("media.m3u8");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    videoFilesConverter.videoFilesProcessing(videoFile);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }

}
