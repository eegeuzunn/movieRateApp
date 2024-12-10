package com.rateMovie.dto;

import com.rateMovie.model.Movie;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class CommentDto {

    private Long id;
    private String comment;
    private LocalDateTime comment_datetime;
    private int rate_point;

    public CommentDto() {
    }

    public CommentDto(String comment, LocalDateTime comment_datetime, int rate_point, Long id) {
        this.comment = comment;
        this.comment_datetime = comment_datetime;
        this.rate_point = rate_point;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getComment_datetime() {
        return comment_datetime;
    }

    public void setComment_datetime(LocalDateTime comment_datetime) {
        this.comment_datetime = comment_datetime;
    }

    public int getRate_point() {
        return rate_point;
    }

    public void setRate_point(int rate_point) {
        this.rate_point = rate_point;
    }
}
