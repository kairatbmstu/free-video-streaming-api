package com.free.freevideostreamingapi.infrastucture.rest.controller;


import com.free.freevideostreamingapi.application.dto.VideoLikeDto;
import com.free.freevideostreamingapi.infrastucture.entity.UserEntity;
import com.free.freevideostreamingapi.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class LikeController {

    @Autowired
    LikeService likeService;

    @PostMapping("/videos/{videoId}/likes")
    public VideoLikeDto postLike(@PathVariable String videoId) {
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (user != null) {
                return likeService.postLike(user.getId(), videoId);
            }
        }
        return null;
    }

    @DeleteMapping("/videos/{videoId}/likes")
    public void deleteLike(@PathVariable String videoId) {
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (user != null) {
                likeService.deleteLikeByVideoId(user.getId(), videoId);
            }
        }
    }


    @PostMapping("/comments/{commentId}/likes")
    public void likeComment(@PathVariable String commentId){
        likeService.likeComment(commentId);
    }

    @DeleteMapping("/comments/{commentId}/likes")
    public void deleteLikeComment(@PathVariable String commentId){
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (user != null) {
                likeService.deleteLikeByCommentId(user.getId(), commentId);
            }
        }
    }

}
