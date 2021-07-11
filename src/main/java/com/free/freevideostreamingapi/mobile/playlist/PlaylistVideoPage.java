package com.free.freevideostreamingapi.mobile.playlist;

import com.free.freevideostreamingapi.comments.Comment;
import com.free.freevideostreamingapi.video.Video;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class PlaylistVideoPage {

    Video video = new Video();

    List<Comment> comments = new ArrayList<>();

    List<Video> playlistVideos = new ArrayList<>();


}
