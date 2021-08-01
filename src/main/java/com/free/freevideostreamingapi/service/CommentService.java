package com.free.freevideostreamingapi.service;

import com.free.freevideostreamingapi.dto.CommentDto;
import com.free.freevideostreamingapi.entity.Comment;
import com.free.freevideostreamingapi.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public List<CommentDto> findComments(@RequestParam int offset, @RequestParam int limit){
        List<CommentDto> comments = new ArrayList<>();
        return comments;
    }

    public CommentDto postComment(@PathVariable String videoId, @RequestBody CommentDto commentDto){
        commentDto.setVideoId(videoId);

        Comment comment = new Comment();
        comment.setVideoId(videoId);
        comment.setLikesNum(0);
        comment.setParentId(commentDto.getParentId());
        comment.setText(commentDto.getText());

        Comment result = commentRepository.save(comment);
        commentDto.setId(result.getId());
        return commentDto;
    }

    public CommentDto putComment(@PathVariable String videoId,@PathVariable String commentId,
                                 @RequestBody CommentDto commentDto){
        commentDto.setVideoId(videoId);
        Comment comment = new Comment();
        comment.setId(commentId);
        comment.setVideoId(videoId);
        comment.setLikesNum(0);
        comment.setParentId(commentDto.getParentId());
        comment.setText(commentDto.getText());

        Comment result = commentRepository.save(comment);
        commentDto.setId(result.getId());
        return commentDto;
    }

    public void deleteComment(@PathVariable String videoId, @PathVariable String commentId,
                              @RequestBody CommentDto commentDto){
        commentDto.setVideoId(videoId);
        Comment comment = new Comment();
        comment.setId(commentId);
        comment.setVideoId(videoId);
        comment.setLikesNum(0);
        comment.setParentId(commentDto.getParentId());
        comment.setText(commentDto.getText());
        commentRepository.delete(comment);
    }

}
