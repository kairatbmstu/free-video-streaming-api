package com.free.freevideostreamingapi.application.dto;

import com.free.freevideostreamingapi.playlist.Playlist;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LibraryPage {

    List<Playlist> playlistList;

}
