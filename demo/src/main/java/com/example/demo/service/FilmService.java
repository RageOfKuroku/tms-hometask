package com.example.demo.service;

import com.example.demo.domain.FilmEntity;
import com.example.demo.mapper.FilmMapper;
import com.example.demo.repos.FilmRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Getter
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository repository;
    private final FilmMapper mapper;


    public List<FilmEntity> getByTitle(String title){
        return repository.findByTitle(title);
    }

    public List<FilmEntity> getByRating(Float rating){
        return repository.findByRating(rating);
    }

    public List<FilmEntity> getByGenre(Genre genre){
        return repository.findByGenre(genre);
    }

    public List<FilmEntity> get(Specification<FilmEntity> spec) {
        return repository.findAll(spec);
    }

}
