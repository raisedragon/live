package com.winit.common.spring;

import com.winit.common.utils.LocalUTCDateTransformer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liuye on 2015/1/28.
 */
@Aspect
public class LocalUTCDateTransformSpringAspect {
    Logger logger= LoggerFactory.getLogger(LocalUTCDateTransformSpringAspect.class);

    @Pointcut("execution(*  com.winit.*.*.controller.*.*Controller(..))")
    private void anyMethod()
    {
    }

    @Before("anyMethod()")
    public void before(JoinPoint joinPoint)
    {
        logger.info(joinPoint.getSignature().getName(), "", joinPoint.getTarget().getClass().getName());
        logger.info(joinPoint.getSignature().getName(), "", "beginning execute method:" + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        LocalUTCDateTransformer.transform(args, LocalUTCDateTransformer.Direction.TO_UTC);
    }

    @AfterReturning(pointcut = "anyMethod()")
    public void AfterReturning(JoinPoint joinPoint)
    {
        logger.info(joinPoint.getSignature().getName(), "", joinPoint.getTarget().getClass().getName());
        logger.info(joinPoint.getSignature().getName(), "", "beginning execute method:" + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        LocalUTCDateTransformer.transform(args, LocalUTCDateTransformer.Direction.TO_LOCAL);
    }
}
