package com.xkcoding.helloworld;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * <p>
 * <a href="LogAspect.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/1/4 17:58
 */
@Log4j2
@Aspect
public class LogAspect {


    @Pointcut("@annotation(com.xkcoding.helloworld.Log)")
    public void pointCut(){}

    @Before("pointCut()")
    public void doBefore(Method method, Object[] args){

    }

}
