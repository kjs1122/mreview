package org.zerock.mreview.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.mreview.dto.MovieDTO;
import org.zerock.mreview.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieServiceTest {

    @Autowired
    private MovieService movieService ;

    @Test
    void getMovie() {
        MovieDTO movie = movieService.getMovie(100L);
        System.out.println("movie = " + movie);
    }
}