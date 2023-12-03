package com.example.demo.domain;

import com.example.demo.service.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Films")
public class FilmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Film")
    @NotBlank

    private String title;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "Genre")
    @NotBlank

    private Genre genre;
    @Column(name = "Release date")
    @NotBlank

    private String dateOfRelease;
    @Column(name = "Rating")
    @NotBlank
    @Min(1)
    @Max(10)
    private Float rating;

}
