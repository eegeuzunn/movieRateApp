package com.rateMovie.service;

import com.rateMovie.dto.CommentDto;
import com.rateMovie.dto.PostCommentRequest;
import com.rateMovie.dto.converter.CommentConverter;
import com.rateMovie.model.Comment;
import com.rateMovie.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentConverter commentConverter;

    public CommentService(CommentRepository commentRepository, CommentConverter commentConverter) {
        this.commentRepository = commentRepository;
        this.commentConverter = commentConverter;
    }

    public CommentDto postAComment(PostCommentRequest postCommentRequest, int id){
        Comment comment = new Comment(
                postCommentRequest.getRate_point(),
                LocalDateTime.now(),
                postCommentRequest.getComment()
        );

        Comment savedComment = commentRepository.save(comment);

        return commentConverter.toDto(savedComment);
    }
}
