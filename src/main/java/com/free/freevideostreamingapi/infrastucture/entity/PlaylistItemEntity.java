package com.free.freevideostreamingapi.infrastucture.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Table("playlist_item")
@Getter
@Setter
public class PlaylistItemEntity {

    @Id
    @PrimaryKey
    String id;

    @NotNull
    String videoId;

    @NotNull
    String playlistId;

    LocalDateTime addedAt;

    int priority;

}
