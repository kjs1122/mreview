package org.zerock.mreview.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.mreview.entity.Movie;
import org.zerock.mreview.entity.MovieImage;

import java.util.UUID;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieImageRepository imageRepository;


    @Test
    void insertMovies() {

        IntStream.rangeClosed(1, 100).forEach(i -> {

            Movie movie = Movie.builder().title("Movie....." + i).build();

            System.out.println("---------------------------------------------");

            movieRepository.save(movie);

            int count = (int) (Math.random() * 5) + 1;

            for (int j = 0; j < count; j++) {
                MovieImage movieImage = MovieImage.builder()
                        .uuid(UUID.randomUUID().toString())
                        .movie(movie)
                        .imgName("test" + j + "jpg").build();

                imageRepository.save(movieImage);
            }
            System.out.println("===============================================");
        });
    }

}