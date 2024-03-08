package com.tanmay.blog.controllers;

import com.tanmay.blog.entities.Comment;
import com.tanmay.blog.payloads.ApiResponse;
import com.tanmay.blog.payloads.CommentDto;
import com.tanmay.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment
            (@RequestBody CommentDto commentDto, @PathVariable Integer postId){
        CommentDto createComment = this.commentService.createComment(commentDto, postId);
        return new ResponseEntity<CommentDto>(createComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> createComment
            (@PathVariable Integer commentId){
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("deleted comment Successfully", true), HttpStatus.OK);
    }


}
