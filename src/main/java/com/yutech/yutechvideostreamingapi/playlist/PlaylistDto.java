package com.yutech.yutechvideostreamingapi.playlist;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PlaylistDto {

    String id;

    String userId;

    List<PlaylistItemDto> items = new ArrayList<PlaylistItemDto>();

}
