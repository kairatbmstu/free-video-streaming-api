package com.free.freevideostreamingapi.domain.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Comment {

    String id;
    String parentId;
    String videoId;
    String text;
    int likesNum;
    LocalDateTime created_at = LocalDateTime.now();

}
