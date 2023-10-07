package hometask;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import hometask.service.implementations.RaceServiceImpl;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("hometask");
        context.registerShutdownHook();

        RaceServiceImpl bean = context.getBean(RaceServiceImpl.class);


        bean.startGame();
    }
}
