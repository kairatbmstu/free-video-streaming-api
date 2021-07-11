package com.free.freevideostreamingapi.mobile.main;

import com.free.freevideostreamingapi.video.Video;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MainPage {

    List<Video> recommendedVideos = new ArrayList<>();

}
