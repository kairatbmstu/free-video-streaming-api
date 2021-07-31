package com.free.freevideostreamingapi.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Table
@Getter
@Setter
public class Library {

    @Id
    @PrimaryKey
    UUID id;
    String userId;
    List<String> playlistIds;

}
