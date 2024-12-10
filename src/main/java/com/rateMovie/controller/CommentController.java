package com.rateMovie.controller;

import com.rateMovie.dto.CommentDto;
import com.rateMovie.dto.PostCommentRequest;
import com.rateMovie.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("movies/{id}/comments")
    public ResponseEntity<CommentDto> postAComment(@RequestBody PostCommentRequest postCommentRequest, @PathVariable int id){
        CommentDto savedCommentDto = commentService.postAComment(postCommentRequest, id);
        return new ResponseEntity<CommentDto>(savedCommentDto, HttpStatus.CREATED);
    }


}
