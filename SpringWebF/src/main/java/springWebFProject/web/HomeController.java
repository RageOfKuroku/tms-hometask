package springWebFProject.web;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springWebFProject.Test;
import springWebFProject.service.TestService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/home")

public class HomeController {

    private final TestService testService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView homePage(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("title", "Hello");
        return modelAndView;
    }
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addItem(@Valid Test test){
        testService.save(test);

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("test", testService.getTest());
        return modelAndView;
    }
    @ExceptionHandler(Exception.class)
    public String processError(){
        System.out.println("Error from page");
        return "error";
    }


}
