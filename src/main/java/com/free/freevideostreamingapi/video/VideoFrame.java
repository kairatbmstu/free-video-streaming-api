package com.free.freevideostreamingapi.video;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Getter
@Setter
@Table
public class VideoFrame {

    @Id
    @PrimaryKey
    @Column("id")
    String id;

    @Column("video_id")
    String videoId;

    @Column("filename")
    String filename;

    @Column("bucket_name")
    String bucketName;

    @Column("key_name")
    String keyName;

    @Column("priority")
    int priority;

}
