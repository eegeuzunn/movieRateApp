package com.rateMovie.repository;

import com.rateMovie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    public Optional<Movie> getMovieById(int id);

    @Query("select AVG(c.rate_point) from Comment c join c.movie m where ?1 = m.id")
    public double getMovieRate(Long movieid);

}
