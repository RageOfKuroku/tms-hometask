package config;

import domain.Horse;
import domain.Horseman;
import domain.Pair;
import domain.UserBalance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import service.implementations.BalanceImpl;
import service.implementations.PairServiceImpl;
import service.implementations.RaceServiceImpl;

import java.util.List;


@Configuration
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
