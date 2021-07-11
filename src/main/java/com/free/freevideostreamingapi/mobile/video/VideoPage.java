package com.free.freevideostreamingapi.mobile.video;

import com.free.freevideostreamingapi.comments.Comment;
import com.free.freevideostreamingapi.domain.model.Video;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class VideoPage {

    Video video = new Video();

    List<Comment> comments = new ArrayList<>();

    List<Video> recommendedVideos = new ArrayList<>();

}
