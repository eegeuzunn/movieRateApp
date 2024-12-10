package com.rateMovie.controller;

import com.rateMovie.dto.MovieDto;
import com.rateMovie.service.MovieService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> gelAllMovies(){
        List<MovieDto> movies = movieService.getAllMovies();
        return new ResponseEntity<List<MovieDto>>(movies, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable int id){
        MovieDto movie = movieService.getSingleMovie(id);
        return new ResponseEntity<MovieDto>(movie, HttpStatus.OK);
    }

    @GetMapping("{id}/banner")
    public ResponseEntity<Resource> getMovieBanner(@PathVariable int id){
        try {
            File banner = movieService.getMovieBanner(id);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + banner.getName() + "\"")
                    .contentLength(banner.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(new InputStreamResource(Files.newInputStream(banner.toPath())));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
