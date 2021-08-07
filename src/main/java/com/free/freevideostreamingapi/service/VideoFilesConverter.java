package com.free.freevideostreamingapi.service;

import com.free.freevideostreamingapi.entity.VideoFile;
import com.free.freevideostreamingapi.repository.VideoFileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.Charset;

@Component
@Slf4j
public class VideoFilesConverter {

    String COMMAND = "ffmpeg -i :input -c:a aac -strict experimental -c:v libx264" +
            " -s :video_resolution -aspect 16:9 -f hls -hls_list_size 0 -hls_time :hls_time :output";

    @Autowired
    VideoFileRepository videoFileRepository;

    public void videoFilesProcessing(VideoFile videoFile) throws IOException, InterruptedException {
        log.info(" Start Video File Processing...");

        if (videoFile == null) {
            log.info("videoFile is null");
            return;
        }

        try {
            log.info("appfile.getInputDir(): ", videoFile.getInputDir());
            log.info("appfile.getOutputDir(): ", videoFile.getOutputDir());
            videoFileRepository.save(videoFile);
            String input = videoFile.getInputDir()  + videoFile.getOriginalFilename();
            String outputDir = videoFile.getOutputDir();
            log.info("outputDir : ", videoFile.getOutputDir());
            File dirout = new File(outputDir);
            dirout.mkdirs();

            int exitCode = 0;
            exitCode = performCommand(input, outputDir, "240_out.m3u8", "360x240", "2");
            if (exitCode != 0) {
                return;
            }
            exitCode = performCommand(input, outputDir, "360_out.m3u8", "480x360", "2");
            if (exitCode != 0) {
                return;
            }
            exitCode = performCommand(input, outputDir, "480_out.m3u8", "858x480", "1");
            if (exitCode != 0) {
                return;
            }
            exitCode = performCommand(input, outputDir, "720_out.m3u8", "1280x720", "1");
            if (exitCode != 0) {
                return;
            }

            M3u8FileBuilder m3u8FilesBuilder = new M3u8FileBuilder();
            m3u8FilesBuilder.setOutput(outputDir, "media.m3u8");
            m3u8FilesBuilder.addM3u8File("240_out.m3u8", "213000", "360x240");
            m3u8FilesBuilder.addM3u8File("360_out.m3u8", "445000", "480x360");
            m3u8FilesBuilder.addM3u8File("480_out.m3u8", "998000", "858x480");
            m3u8FilesBuilder.addM3u8File("720_out.m3u8", "1896000", "1280x720");
            m3u8FilesBuilder.flush();

        } catch (Exception e) {
            log.error("Video files processing is failed...", e);
        }
    }

    /**
     * https://www.quora.com/What-are-these-240p-360p-480p-720p-1080p-units-for-videos-Whats-the-basic-idea-behind-it
     * 240p = 352 x 240
     * 360 p = 480 x 360
     * 480p = 858 x 480 — also known as SD
     * 720p = 1280 x 720 — the old TVs of this resolution were marked HDready
     * 1080p = 1920 x 1080 — FullHD
     * 2160p = 3860 x 2160 —Ultra-HD, also known as 4K (that’s a marketing trick)
     */

    /**
     * 1. For 352x240
     * ffmpeg -i input.mp4 -c:a aac -strict experimental -c:v libx264 -s 360x240 -aspect 16:9 -f hls -hls_list_size 0 -hls_time 10 240_out.m3u8
     * 2. For 480x360
     * ffmpeg -i input.mp4 -c:a aac -strict experimental -c:v libx264 -s 480x360 -aspect 16:9 -f hls -hls_list_size 0 -hls_time 10 360_out.m3u8
     * 3. For 858x480
     * ffmpeg -i input.mp4 -c:a aac -strict experimental -c:v libx264 -s 858x480 -aspect 16:9 -f hls -hls_list_size 0 -hls_time 5 480_out.m3u8
     * 4. For 1280x720
     * ffmpeg -i input.mp4 -c:a aac -strict experimental -c:v libx264 -s 1280x720 -aspect 16:9 -f hls -hls_list_size 0 -hls_time 2 720_out.m3u8
     */
    private int performCommand(String input, String outputDir, String outputM3u8Filename, String videoResolution, String hls_time) throws IOException, InterruptedException {
        System.out.println("input : " + input);
        System.out.println("outputDir : " + outputDir);
        System.out.println("outputM3u8Filename : " + outputM3u8Filename);
        System.out.println("videoResolution : " + videoResolution);
        System.out.println("hls_time : " + hls_time);
        Process process = Runtime.getRuntime()
                .exec(COMMAND.replaceAll(":input", input)
                        .replaceAll(":output", outputDir + "/" + outputM3u8Filename)
                        .replaceAll(":video_resolution", videoResolution)
                        .replaceAll(":hls_time", hls_time));
        try (BufferedReader r = new BufferedReader(
                new InputStreamReader(process.getErrorStream()))) {
            String line = null;
            while ((line = r.readLine()) != null) {
                log.info(line);
            }
            int exitCode = process.waitFor();
            log.info("exitCode : " + exitCode);
            return exitCode;
        }
    }


}



/**
 * #EXTM3U
 * #EXT-X-VERSION:4
 * #EXT-X-STREAM-INF:BANDWIDTH=1896000,AVERAGE-BANDWIDTH=1649000,RESOLUTION=1280x720,CLOSED-CAPTIONS=NONE,CODECS="avc1.4d001e,mp4a.40.2"
 * 720.m3u8
 * #EXT-X-STREAM-INF:BANDWIDTH=998000,AVERAGE-BANDWIDTH=868000,RESOLUTION=640x480,CLOSED-CAPTIONS=NONE,CODECS="avc1.4d001e,mp4a.40.5"
 * 480.m3u8
 * #EXT-X-STREAM-INF:BANDWIDTH=445000,AVERAGE-BANDWIDTH=387000,RESOLUTION=480x360,CLOSED-CAPTIONS=NONE,CODECS="avc1.4d001e,mp4a.40.5"
 * 360.m3u8
 * #EXT-X-STREAM-INF:BANDWIDTH=213000,AVERAGE-BANDWIDTH=186000,RESOLUTION=360x240,CLOSED-CAPTIONS=NONE,CODECS="avc1.4d001e,mp4a.40.5"
 * 240.m3u8
 */
class M3u8FileBuilder {
    StringBuilder result = new StringBuilder();
    File outputFile;

    public M3u8FileBuilder() {
        result.append("#EXTM3U\n");
        result.append("#EXT-X-VERSION:4\n");
    }

    public void setOutput(String outputDir, String outputM3u8Filename) {
        outputFile = new File(outputDir + "/" + outputM3u8Filename);
    }

    public void addM3u8File(String m3u8File, String bandwith, String resolution) {
        result.append("#EXT-X-STREAM-INF:PROGRAM-ID=1,BANDWIDTH=" + bandwith + ",RESOLUTION=" + resolution + "\n");
        result.append(m3u8File + "\n");
    }

    public void flush() {
        try {
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                fos.write(result.toString().getBytes(Charset.forName("UTF-8")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}