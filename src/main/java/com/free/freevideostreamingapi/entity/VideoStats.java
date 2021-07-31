package com.free.freevideostreamingapi.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;

@Getter
@Setter
public class VideoStats {

    @Column("likes_num")
    int likesNum;

    @Column("dislikes_num")
    int dislikesNum;

    @Column("total_views_number")
    int totalViewsNumber;
}
