package com.luxoft.pikuza.aspect;

import com.luxoft.pikuza.exceptions.CustomExceptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {
    private Logger logger = LogManager.getLogger(Logging.class);

    @AfterThrowing(pointcut = "execution(* com.luxoft.pikuza.controllers.*.*(..))" , throwing = "ex")
    public void AfterThrowingController(JoinPoint joinPoint , CustomExceptions ex) throws Throwable {
        logger.error(joinPoint.getSignature() + "- in method error");
    }

    @AfterThrowing(pointcut = "execution(* com.luxoft.pikuza.services.*.*(..))" , throwing = "ex")
    public void AfterThrowingService(JoinPoint joinPoint , CustomExceptions ex) throws Throwable {
        logger.error(joinPoint.getSignature() + "- in method error");
    }
}

