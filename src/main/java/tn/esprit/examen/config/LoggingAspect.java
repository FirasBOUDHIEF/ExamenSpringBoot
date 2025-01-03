package tn.esprit.examen.config;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


import org.apache.logging.log4j.*;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger l = LogManager.getLogger(LoggingAspect.class);
    @After("execution(* tn.esprit.examen.service.ServiceExamenImpl.add*(..))")
    public void logMethodeExit(JoinPoint joinPoint) {
      l.info("methode executé");
    }

    @Before("execution( * tn.esprit.examen.service.ServiceExamenImpl.add*())")
    public void logMethodeEntry(JoinPoint joinPoint) {
        l.info("methode bsh tabda aw texecuti");
    }

    @Around("execution(* tn.esprit.examen.service.ServiceExamenImpl.add*(..))")
    public Object profile(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start=System.currentTimeMillis();
        Object obj=proceedingJoinPoint.proceed();
        long elapsedTime=System.currentTimeMillis();
        l.info("Arround methode : execution"+elapsedTime);
        return obj;


    }

}
