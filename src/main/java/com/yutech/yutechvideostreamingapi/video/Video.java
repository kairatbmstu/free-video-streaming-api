package com.yutech.yutechvideostreamingapi.video;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Embedded;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;


/**
 * Video - video file's metadata class
 */

@Getter
@Setter
@Table
public class Video {

    @Id
    @PrimaryKey
    @Column("id")
    String id;

    @Column("title")
    String title;

    @Column("description")
    String description;

    //video file
    String videoFileId;

    @Embedded.Empty
    VideoStats videoStats;

    @Column("external_url")
    String externalUrl;

    @Embedded.Empty
    VideoLocation location;

    @Column("channel_id")
    String channelId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return Objects.equals(id, video.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
