package com.example.validation.dto;

import com.example.validation.validate.ValidMovieTitle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {
    @ValidMovieTitle
    private String title;

}
