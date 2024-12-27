package com.rateMovie.service;

import com.rateMovie.dto.MovieDto;
import com.rateMovie.dto.converter.MovieConverter;
import com.rateMovie.exception.EntityNotFoundException;
import com.rateMovie.model.Movie;
import com.rateMovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieConverter movieConverter;

    @Value("${banner.directory}")
    private String BANNER_FILE_PATH;

    public MovieService(MovieRepository movieRepository, MovieConverter movieConverter) {
        this.movieRepository = movieRepository;
        this.movieConverter = movieConverter;
    }

    public List<MovieDto> getAllMovies(){
        var movies = movieRepository.findAll();

        if(movies.isEmpty()){
            throw new EntityNotFoundException("There are no movie");
        }

        return movies.stream()
                .map(x -> {
                            double rating = movieRepository.getMovieRate(x.getId());
                            return movieConverter.toDto(x, rating);
                        }
                )
                .collect(Collectors.toList());
    }


    public MovieDto getSingleMovie(int id){
        var movie = movieRepository.getMovieById(id).orElseThrow(() ->  new EntityNotFoundException("No movie with that id"));
        double rating = movieRepository.getMovieRate((long) id);
        return movieConverter.toDto(movie, rating);
    }

    public File getMovieBanner(int id) throws FileNotFoundException {
        Movie movie = movieRepository.findById((long) id).orElseThrow(()-> new EntityNotFoundException("There are no movie with that id"));

        File fileToSend = new File(movie.getPosterPath());

        if(!fileToSend.exists()){
            throw new FileNotFoundException("Banner not found");
        }

        return fileToSend;
    }

}
