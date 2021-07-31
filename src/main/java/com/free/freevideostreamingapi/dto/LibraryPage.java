package com.free.freevideostreamingapi.dto;

import com.free.freevideostreamingapi.entity.Playlist;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LibraryPage {

    List<Playlist> playlistList;

}
