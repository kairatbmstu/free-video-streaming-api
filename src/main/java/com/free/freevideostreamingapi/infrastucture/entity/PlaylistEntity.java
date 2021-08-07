package com.free.freevideostreamingapi.infrastucture.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import javax.validation.constraints.NotNull;
import java.util.List;


@Table("playlist")
@Getter
@Setter
public class PlaylistEntity {

    @Id
    @PrimaryKey
    String id;

    @NotNull
    String userId;

    List<String> playlistItems;

}
