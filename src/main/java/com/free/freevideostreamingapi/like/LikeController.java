package com.free.freevideostreamingapi.like;


import com.free.freevideostreamingapi.domain.model.User;
import com.free.freevideostreamingapi.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class LikeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    LikeRepository likeRepository;

    @PostMapping("/videos/{videoId}/likes")
    public VideoLikeDto postLike(@PathVariable String videoId) {
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (user != null) {
                Like like = likeRepository.findFirstByUserIdAndVideoId(user.getId(), videoId);
                if (like==null) {
                    like = new Like();
                    like.setId(UUID.randomUUID().toString());
                    like.setUserId(user.getId());
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
        }
        return null;
    }

    @DeleteMapping("/videos/{videoId}/likes")
    public void deleteLike(@PathVariable String videoId) {
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (user != null) {
                Like like = likeRepository.findFirstByUserIdAndVideoId(user.getId(), videoId);
                likeRepository.delete(like);
            }
        }
    }


    @PostMapping("/comments/{commentId}/likes")
    public void likeComment(@PathVariable String commentId){

    }

    @DeleteMapping("/comments/{commentId}/likes")
    public void deleteLikeComment(@PathVariable String commentId){

    }

}
