package com.free.freevideostreamingapi.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/videos/{videoId}/comments")
    public List<CommentDto> findComments(@RequestParam int offset, @RequestParam int limit){
        List<CommentDto> comments = new ArrayList<>();
        return comments;
    }

    @PostMapping("/videos/{videoId}/comments")
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

    @PutMapping("/videos/{videoId}/comments/{commentId}")
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

    @DeleteMapping("/videos/{videoId}/comments/{commentId}")
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
