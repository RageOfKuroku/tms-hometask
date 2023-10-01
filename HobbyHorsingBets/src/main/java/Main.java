import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.implementations.RaceServiceImpl;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("hobbyHorsingConfiguration.xml");

        RaceServiceImpl bean = applicationContext.getBean(RaceServiceImpl.class);
        bean.startGame();
    }
}
