package com.yutech.yutechvideostreamingapi.mobile.main;

import com.yutech.yutechvideostreamingapi.video.Video;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MainPage {

    List<Video> recommendedVideos = new ArrayList<>();

}
