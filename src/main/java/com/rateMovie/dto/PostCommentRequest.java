package com.rateMovie.dto;

import java.time.LocalDateTime;

public class PostCommentRequest {
    private String comment;
    private int rate_point;

    public PostCommentRequest() {
    }

    public PostCommentRequest(int rate_point, String comment) {
        this.rate_point = rate_point;
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRate_point() {
        return rate_point;
    }

    public void setRate_point(int rate_point) {
        this.rate_point = rate_point;
    }
}
