package springWebFProject.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springWebFProject.Test;
import springWebFProject.service.TestService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/home")

public class HomeController {

    private final TestService testService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView homePage(@ModelAttribute(name = "test")Test test){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("title", "Hello");
        return modelAndView;
    }
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addItem(@ModelAttribute(name = "test") @Valid Test test, BindingResult result){


        ModelAndView modelAndView = new ModelAndView("home");

        if(!result.hasFieldErrors()) {
            testService.save(test);
            modelAndView.addObject("test", new Test());
        }
        modelAndView.addObject("tests", testService.getTest());
        return modelAndView;
    }
    @ExceptionHandler(Exception.class)
   public String processError(){
       System.out.println("Error from page");
       return "error";
    }


}
