package com.free.freevideostreamingapi.application.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
public class VideoUploadRequest {

    String title;

    String description;

    MultipartFile file;
}
