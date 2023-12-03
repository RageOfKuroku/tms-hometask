package com.example.demo.service;

import com.example.demo.domain.FilmEntity;
import org.springframework.data.jpa.domain.Specification;

public class FilmSpecification {
    public static Specification<FilmEntity> titleContains(String title) {
        return (root, query, cb) -> {
            if (title == null) {
                return cb.isTrue(cb.literal(true));
            }
            return cb.like(root.get("title"), "%" + title + "%");
        };
    }

    public static Specification<FilmEntity> genreIs(Genre genre) {
        return (root, query, cb) -> {
            if (genre == null) {
                return cb.isTrue(cb.literal(true));
            }
            return cb.equal(root.get("genre"), genre);
        };
    }

    public static Specification<FilmEntity> ratingBetween(Double from, Double to) {
        return (root, query, cb) -> {
            if (from == null || to == null) {
                return cb.isTrue(cb.literal(true));
            }
            return cb.between(root.get("rating"), from, to);
        };
    }


}
