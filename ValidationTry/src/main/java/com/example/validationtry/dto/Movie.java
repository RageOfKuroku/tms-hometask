package com.example.validationtry.dto;

import com.example.validationtry.validate.ValidMovieTitle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {

    private Integer id;
    @ValidMovieTitle
    private String title;

}
