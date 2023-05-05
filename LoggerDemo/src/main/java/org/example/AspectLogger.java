package org.example;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;




@Aspect
public class AspectLogger {
    private Logger aspectLogger = LogManager.getLogger(AspectLogger.class);
    @Around("execution( * com.services..*.*(.. ))")
    public Object applyLogging(ProceedingJoinPoint joinPoint)throws Throwable{
        long start=System.currentTimeMillis();
        Object value=joinPoint.proceed();
        long end=System.currentTimeMillis();
        aspectLogger.info("Time Taken To Execute the Method is : "+joinPoint.getSignature().getName()+":"+ (end-start)+"ms" );
        return value;
    }

    @Before("execution(* com.services.CustomerServiceImpl.getByCode(..))")
    public void applyAdviceGetAllByCode(){
        aspectLogger.info("Fetching All Details.. ");}


}
