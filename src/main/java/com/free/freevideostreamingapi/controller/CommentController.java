package com.free.freevideostreamingapi.controller;

import com.free.freevideostreamingapi.entity.Comment;
import com.free.freevideostreamingapi.dto.CommentDto;
import com.free.freevideostreamingapi.repository.CommentRepository;
import com.free.freevideostreamingapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/videos/{videoId}/comments")
    public List<CommentDto> findComments(@RequestParam int offset, @RequestParam int limit){
        return commentService.findComments(offset, limit);
    }

    @PostMapping("/videos/{videoId}/comments")
    public CommentDto postComment(@PathVariable String videoId, @RequestBody CommentDto commentDto){
       return commentService.postComment(videoId,commentDto);
    }

    @PutMapping("/videos/{videoId}/comments/{commentId}")
    public CommentDto putComment(@PathVariable String videoId,@PathVariable String commentId,
                                 @RequestBody CommentDto commentDto){
       return commentService.putComment(videoId, commentId, commentDto);
    }

    @DeleteMapping("/videos/{videoId}/comments/{commentId}")
    public void deleteComment(@PathVariable String videoId, @PathVariable String commentId,
                              @RequestBody CommentDto commentDto){
        commentService.deleteComment(videoId, commentId, commentDto);
    }

}
