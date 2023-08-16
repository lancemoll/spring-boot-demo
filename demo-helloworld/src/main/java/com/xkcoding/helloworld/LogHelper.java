package com.xkcoding.helloworld;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * <p>
 * <a href="LogHelper.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/1/4 14:00
 */
public class LogHelper implements MethodBeforeAdvice, AfterReturningAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {

    }

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {

    }
}
