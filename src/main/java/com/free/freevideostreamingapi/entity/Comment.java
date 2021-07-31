package com.free.freevideostreamingapi.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Table("comment")
public class Comment {

    @Id
    @PrimaryKey
    @Column("id")
    String id;

    @Column("parent_id")
    String parentId;

    @Column("video_id")
    String videoId;

    @Column("text")
    String text;

    @Column("likes_num")
    int likesNum;

    @Column("created_at")
    LocalDateTime created_at = LocalDateTime.now();

}
