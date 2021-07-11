package com.free.freevideostreamingapi.web.playlist;

import com.free.freevideostreamingapi.playlist.Playlist;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;



@Getter
@Setter
public class PlaylistPage {

    List<Playlist> playlists = new ArrayList<>();

}
