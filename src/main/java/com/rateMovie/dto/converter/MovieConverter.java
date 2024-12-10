package com.rateMovie.dto.converter;

import com.rateMovie.dto.MovieDto;
import com.rateMovie.model.Movie;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MovieConverter {
    private final CategoryConverter categoryConverter;
    private final CommentConverter commentConverter;

    public MovieConverter(CategoryConverter categoryConverter, CommentConverter commentConverter) {
        this.categoryConverter = categoryConverter;
        this.commentConverter = commentConverter;
    }

    public MovieDto toDto(Movie from, double rating){
        return new MovieDto(
                from.getId(),
                from.getName(),
                from.getDescription(),
                from.getMinute(),
                from.getReleaseDate(),
                from.getCategories().stream()
                        .map(categoryConverter::toDto)
                        .collect(Collectors.toList()),
                from.getComments().stream()
                        .map(commentConverter::toDto)
                        .collect(Collectors.toList()
                        ),
                rating
        );
    }

}
