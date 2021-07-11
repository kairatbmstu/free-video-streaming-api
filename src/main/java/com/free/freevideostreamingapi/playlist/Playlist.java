package com.free.freevideostreamingapi.playlist;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Table("playlist")
@Getter
@Setter
public class Playlist {

    @Id
    @PrimaryKey
    String id;

    @NotNull
    String userId;

    List<String> playlistItems = new ArrayList<>();

}
