package com.free.freevideostreamingapi.infrastucture.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
@Getter
@Setter
public class ChannelEntity {

    @Id
    @PrimaryKey
    @Column("id")
    String id;

    String userId;

    @Column("title")
    String title;

    @Column("description")
    String description;

    @Column("subscribers_num")
    int subsribersNum;

}
