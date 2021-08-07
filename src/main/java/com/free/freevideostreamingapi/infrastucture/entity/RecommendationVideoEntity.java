package com.free.freevideostreamingapi.infrastucture.entity;

import org.springframework.data.cassandra.core.mapping.Column;

import java.time.LocalDateTime;

public class RecommendationVideoEntity {

    @Column
    String videoId;

    @Column
    String videoTitle;

    @Column
    String videoText;

    @Column
    String videoTags;

    @Column
    LocalDateTime videoCreatedAt;

}
