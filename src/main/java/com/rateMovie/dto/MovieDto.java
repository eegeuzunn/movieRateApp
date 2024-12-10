package com.rateMovie.dto;

import com.rateMovie.model.Category;
import com.rateMovie.model.Comment;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class MovieDto {

    private Long id;

    private String name;

    private String description;

    private int minute;

    private LocalDate releaseDate;

    private List<CategoryDto> categories;

    private List<CommentDto> comments;

    private double rating;

    public MovieDto() {

    }

    public MovieDto(Long id, String name, String description, int minute, LocalDate releaseDate, List<CategoryDto> categories, List<CommentDto> comments, double rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.minute = minute;
        this.releaseDate = releaseDate;
        this.categories = categories;
        this.comments = comments;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDto> categories) {
        this.categories = categories;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
