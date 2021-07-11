package com.yutech.yutechvideostreamingapi.web.playlist;

import com.yutech.yutechvideostreamingapi.comments.Comment;
import com.yutech.yutechvideostreamingapi.video.Video;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;



@Getter
@Setter
public class PlaylistVideoPage {

    Video video = new Video();

    List<Comment> comments = new ArrayList<>();

    List<Video> recommendedVideos = new ArrayList<>();


}
