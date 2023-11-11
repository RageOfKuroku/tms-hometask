package com.example.demo.repos;

import com.example.demo.domain.FilmEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {
    @Modifying
    @Transactional
    @Query("update FilmEntity set rating = :newRating where id = :id")
    void updateRating(Integer id, Float newRating);

}
