package com.free.freevideostreamingapi.domain.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Playlist {
    String id;
    String userId;
    List<String> playlistItems = new ArrayList<String>();
}
