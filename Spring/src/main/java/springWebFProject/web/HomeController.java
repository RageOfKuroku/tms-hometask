package springWebFProject.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springWebFProject.Test;
import springWebFProject.service.TestService;

import javax.validation.Valid;
import java.util.List;

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
    public ModelAndView addItem(@Valid Test test, BindingResult result){


        ModelAndView modelAndView = new ModelAndView("home");

        if(result.hasFieldErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            fieldErrors.forEach(fieldError -> {
                String field = fieldError.getField();
                String defaultMessage = fieldError.getDefaultMessage();
                modelAndView.addObject(field + "Error", defaultMessage);
            });

        }else{
            testService.save(test);
            modelAndView.addObject("test", testService.getTest());
        }



        return modelAndView;
    }
    @ExceptionHandler(Exception.class)
   public String processError(){
       System.out.println("Error from page");
       return "error";
    }


}
