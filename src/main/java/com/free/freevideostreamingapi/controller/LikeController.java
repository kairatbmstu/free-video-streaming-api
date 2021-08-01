package com.free.freevideostreamingapi.controller;


import com.free.freevideostreamingapi.entity.User;
import com.free.freevideostreamingapi.repository.LikeRepository;
import com.free.freevideostreamingapi.repository.UserRepository;
import com.free.freevideostreamingapi.entity.Like;
import com.free.freevideostreamingapi.dto.VideoLikeDto;
import com.free.freevideostreamingapi.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class LikeController {

    @Autowired
    LikeService likeService;

    @PostMapping("/videos/{videoId}/likes")
    public VideoLikeDto postLike(@PathVariable String videoId) {
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (user != null) {
                return likeService.postLike(user.getId(), videoId);
            }
        }
        return null;
    }

    @DeleteMapping("/videos/{videoId}/likes")
    public void deleteLike(@PathVariable String videoId) {
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (user != null) {
                likeService.deleteLikeByCommentId(user.getId(), commentId);
            }
        }
    }

}
