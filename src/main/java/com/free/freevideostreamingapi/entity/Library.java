package com.free.freevideostreamingapi.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Table
public class Library {

    @Id
    @PrimaryKey
    UUID id;
    String userId;
    List<String> playlistIds;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getPlaylistIds() {
        return playlistIds;
    }

    public void setPlaylistIds(List<String> playlistIds) {
        this.playlistIds = playlistIds;
    }
}
