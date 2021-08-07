package com.free.freevideostreamingapi.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class PlaylistItemDto {

    String id;

    VideoDto videoDto;

    LocalDateTime addedAt;

    int priority;

}