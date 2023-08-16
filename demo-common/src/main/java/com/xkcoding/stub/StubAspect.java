package com.xkcoding.stub;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * 打桩的切面
 * <p>
 * <a href="StubAspect.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/3/21 10:54
 */
@Aspect
@Slf4j
@Order(Integer.MAX_VALUE)
public class StubAspect {

    @Autowired(required = false)
    private Map<String, Stub> stubMap;
    @Autowired
    private Environment environment;



    @Pointcut("@annotation(com.xkcoding.stub.Stub4Test)")
    public void stubPointcut() {
    }

    @Around(value = "stubPointcut()")
    public Object aroundLog(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        Method method = ((MethodSignature) point.getSignature()).getMethod();
        Stub4Test annotation = method.getAnnotation(Stub4Test.class);
        // 配置文件中的参数
        String paramKey = annotation.paramKey();
        String property = environment.getProperty("stub."+ paramKey);

        String beanName = annotation.stubBeanName();
        Stub stub = stubMap.get(beanName);
        if (stub == null) {
            log.warn("容器中不存在改bean:{}",beanName);
            return point.proceed();
        }
        return stub.stub(args, property, point);
    }
}
