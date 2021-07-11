package com.free.freevideostreamingapi.video;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
class VideoUploadRequest {

    String title;

    String description;

    MultipartFile file;
}
