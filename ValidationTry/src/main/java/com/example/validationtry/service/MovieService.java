package com.example.validationtry.service;

import com.example.validationtry.dto.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    //Без репозитория, потому что чёто он не хочет с репозиторием работать
    private final List<Movie> movies = new ArrayList<>();

    public Movie createMovie(Movie movie) {
        movies.add(movie);
        return movie;
    }

    public List<Movie> getAllMovies() {
        return movies;
    }
}


