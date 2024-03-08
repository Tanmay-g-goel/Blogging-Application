package com.tanmay.blog.services.impl;

import com.tanmay.blog.entities.Comment;
import com.tanmay.blog.entities.Post;
import com.tanmay.blog.exceptions.ResourceNotFoundException;
import com.tanmay.blog.payloads.CommentDto;
import com.tanmay.blog.repositories.CommentRepo;
import com.tanmay.blog.repositories.PostRepo;
import com.tanmay.blog.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {

        Post post = this.postRepo.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post", "post id", postId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);

        comment.setPost(post);

        Comment savedComment = this.commentRepo.save(comment);
        return this.modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepo.findById(commentId)
                .orElseThrow(()-> new ResourceNotFoundException("Comment", "comment id", commentId));

        this.commentRepo.delete(comment);
    }
}
