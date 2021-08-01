package com.free.freevideostreamingapi.service;


import com.free.freevideostreamingapi.dto.VideoLikeDto;
import com.free.freevideostreamingapi.entity.Like;
import com.free.freevideostreamingapi.entity.User;
import com.free.freevideostreamingapi.repository.LikeRepository;
import com.free.freevideostreamingapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LikeService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    LikeRepository likeRepository;

    public VideoLikeDto postLike(String userId, String videoId) {
        Like like = likeRepository.findFirstByUserIdAndVideoId(userId, videoId);
        if (like == null) {
            like = new Like();
            like.setId(UUID.randomUUID().toString());
            like.setUserId(userId);
            like.setVideoId(videoId);
            like = likeRepository.save(like);
            VideoLikeDto videoLikeDto = new VideoLikeDto();
            videoLikeDto.setId(like.getId());
            videoLikeDto.setUserId(like.getUserId());
            videoLikeDto.setVideoId(like.getVideoId());
            return videoLikeDto;
        } else {
            VideoLikeDto videoLikeDto = new VideoLikeDto();
            videoLikeDto.setId(like.getId());
            videoLikeDto.setUserId(like.getUserId());
            videoLikeDto.setVideoId(like.getVideoId());
            return videoLikeDto;
        }
    }

    public void deleteLikeByVideoId(String userId, String videoId) {
        Like like = likeRepository.findFirstByUserIdAndVideoId(userId, videoId);
        likeRepository.delete(like);
    }

    public void likeComment(String commentId) {

    }

    public void deleteLikeByCommentId(String userId, String commentId) {

    }

}
