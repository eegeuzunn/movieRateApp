package com.rateMovie.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;
    @Column(nullable = false)
    private String comment;
    @Column(nullable = false)
    private LocalDateTime comment_datetime;
    @Column(nullable = false)
    private int rate_point;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Comment(int rate_point, LocalDateTime comment_datetime, String comment) {
        this.rate_point = rate_point;
        this.comment_datetime = comment_datetime;
        this.comment = comment;
    }

    public Comment() {
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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
