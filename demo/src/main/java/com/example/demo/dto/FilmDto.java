package com.example.demo.dto;

import com.example.demo.service.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilmDto {
    private Integer id;
    private String title;
    @NotBlank
    private Genre genre;
    @NotBlank
    private String dateOfRelease;
    @NotBlank
    @Min(1)
    @Max(10)
    private Float rating;
}
