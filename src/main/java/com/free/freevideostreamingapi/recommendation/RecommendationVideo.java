package com.free.freevideostreamingapi.recommendation;

import org.springframework.data.cassandra.core.mapping.Column;

import java.time.LocalDateTime;

public class RecommendationVideo {

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
