package hometask.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class AspectMe {
    @Pointcut("execution(public void hometask.service.implementations.RaceServiceImpl.startGame())")
    public void myPointCut(){

    }
    @Around("myPointCut()")
    public void doAspect(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.nanoTime();
        joinPoint.proceed();
        long end = System.nanoTime();
        System.out.println("Time of Race is " + (end - start));
    }
}
