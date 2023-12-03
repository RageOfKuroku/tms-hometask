package com.example.demo.repos;

import com.example.demo.domain.FilmEntity;
import com.example.demo.service.Genre;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FilmRepository extends JpaRepository<FilmEntity, Long>, JpaSpecificationExecutor<FilmEntity> {
    @Modifying
    @Transactional
    @Query("update FilmEntity set rating = :newRating where id = :id")
    void updateRating(Integer id, Float newRating);

    List<FilmEntity> findByTitle(String title);

    List<FilmEntity> findByRating(Float rating);
    List<FilmEntity> findByGenre(Genre genre);

}
