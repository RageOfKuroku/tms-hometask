package com.example.demo.web;


import com.example.demo.domain.FilmEntity;
import com.example.demo.dto.FilmDto;
import com.example.demo.mapper.FilmMapper;
import com.example.demo.repos.FilmRepository;
import com.example.demo.service.FilmService;
import com.example.demo.service.FilmSpecification;
import com.example.demo.service.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final FilmRepository filmRepository;
    private final FilmService filmService;
    private final FilmMapper filmMapper;
    public static final String HOME_PAGE = "home";


    @GetMapping
    public ModelAndView homePage(FilmDto film) {
        var modelAndView = new ModelAndView(HOME_PAGE);
        List<FilmEntity> all = filmRepository.findAll();
        modelAndView.addObject("films", all);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView savePage(@Valid @ModelAttribute(name = "film") FilmEntity film, BindingResult bindingResult) {

        var modelAndView = new ModelAndView("redirect:/home");
        if (!bindingResult.hasFieldErrors()) {
            filmRepository.save(film);
        }
        return modelAndView;

    }
    @PostMapping("/update/{id}")
    public ModelAndView updatePage(@PathVariable(name = "id")Integer id,@RequestParam(name="newRatingForUpdate") Float newRating){
        var modelAndView = new ModelAndView("redirect:/home");
        filmRepository.updateRating(id, newRating);
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(@RequestParam(name = "title", required = false) String title,
                               @RequestParam(name = "genre", required = false) Genre genre,
                               @RequestParam(name = "ratingFrom", required = false) Double ratingFrom,
                               @RequestParam(name = "ratingTo", required = false) Double ratingTo,
                               @ModelAttribute(name = "newFilm") FilmDto dto) {

        var modelAndView = new ModelAndView("home");

        Specification<FilmEntity> spec = Specification.where(null);

        if (isNotBlank(title)) {
            spec = spec.and(FilmSpecification.titleContains(title));
        }

        if (genre != null) {
            spec = spec.and(FilmSpecification.genreIs(genre));
        }

        if (ratingFrom != null && ratingTo != null) {
            spec = spec.and(FilmSpecification.ratingBetween(ratingFrom, ratingTo));
        }

        List<FilmEntity> films = filmService.get(spec);
        modelAndView.addObject("films", filmMapper.toListDto(films));

        return modelAndView;
    }





}
