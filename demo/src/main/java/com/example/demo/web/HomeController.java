package com.example.demo.web;


import com.example.demo.domain.FilmEntity;
import com.example.demo.repos.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final FilmRepository filmRepository;
    public static final String HOME_PAGE = "home";


    @GetMapping
    public ModelAndView homePage(FilmEntity film) {
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


}
