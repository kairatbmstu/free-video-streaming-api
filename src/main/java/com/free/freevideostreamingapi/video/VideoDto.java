package com.free.freevideostreamingapi.video;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class VideoDto {

    String id;

    @NotBlank(message = "title is mandatory")
    String title;

    String description;

    VideoStats videoStats;

    @NotBlank(message = "externalUrl is mandatory")
    String externalUrl;

    @NotNull(message = "location is mandatory")
    VideoLocation location;

    LocalDateTime createdAt = LocalDateTime.now();

}
