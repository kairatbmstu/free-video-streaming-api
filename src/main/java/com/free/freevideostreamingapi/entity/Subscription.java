package com.free.freevideostreamingapi.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@Table
public class Subscription {

    @Id
    @PrimaryKey
    String id;

    @Column
    String userId;

    @Column
    String channelId;

    @Column
    LocalDateTime subscribeDatetime;

}
