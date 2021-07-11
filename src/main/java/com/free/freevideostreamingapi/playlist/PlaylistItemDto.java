package com.free.freevideostreamingapi.playlist;

import com.free.freevideostreamingapi.video.VideoDto;
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
