import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.implementations.RaceServiceImpl;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("config");
        context.registerShutdownHook();

        RaceServiceImpl bean = context.getBean(RaceServiceImpl.class);
        RaceServiceImpl bean1 = context.getBean(RaceServiceImpl.class);
        bean.startGame();
        bean1.startGame();
    }
}
