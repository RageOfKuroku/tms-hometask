package hometask.config;

import hometask.domain.Horse;
import hometask.domain.Horseman;
import hometask.domain.Pair;
import hometask.domain.UserBalance;
import hometask.service.implementations.BalanceImpl;
import hometask.service.implementations.PairServiceImpl;
import hometask.service.implementations.RaceServiceImpl;
import org.springframework.context.annotation.*;

import java.util.List;


@Configuration
@ComponentScan("hometask.*")
@EnableAspectJAutoProxy

public class AppConfig {
    @Bean
    Horse horse1(){
        return new Horse("horse1");
    }
    @Bean
    Horse horse2(){
        return new Horse("horse2");
    }
    @Bean
    Horse horse3(){
        return new Horse("horse3");
    }
    @Bean
    Horseman horseman1(){
        return new Horseman("horseman1");
    }
    @Bean
    Horseman horseman2(){
        return new Horseman("horseman2");
    }
    @Bean
    Horseman horseman3(){
        return new Horseman("horseman3");
    }




    @Bean
    Pair pair1(){
        return new Pair(horseman1(),horse1());
    }
    @Bean
    Pair pair2(){
        return new Pair(horseman2(),horse2());
    }
    @Bean
    Pair pair3(){
        return new Pair(horseman3(),horse3());
    }

    @Bean
    @Scope("prototype")
    UserBalance userBalance(){
        return new UserBalance();
    }
    @Bean
    PairServiceImpl pairs(List<Pair> pairs){
        return new PairServiceImpl(pairs);
    }
    @Bean
    @Scope("prototype")
    BalanceImpl balance(){
        return new BalanceImpl(userBalance());
    }

    @Bean
    @Scope("prototype")
    RaceServiceImpl raceService(BalanceImpl balance, PairServiceImpl pairService){
        return new RaceServiceImpl(balance, pairService);
    }


}
