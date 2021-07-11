package com.free.freevideostreamingapi.web.main;

import com.free.freevideostreamingapi.video.Video;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MainPage {

    List<List<Video>> recommendedVideos = new ArrayList<>();

}
