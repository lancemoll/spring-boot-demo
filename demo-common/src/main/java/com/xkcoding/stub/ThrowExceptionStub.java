package com.xkcoding.stub;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * <p>
 * <a href="ThrowExceptionStub.java"><i>View Source</i></a>
 * 抛异常stub
 * @author Conan.chen
 * Date: 2023/3/17 9:20
 */
@Slf4j
public class ThrowExceptionStub implements Stub {

    @Override
    public Object stub(Object[] args, String stubParam, ProceedingJoinPoint pjp) {
        log.info("配置中心获取参数：{}", stubParam);
        if (stubParam == null ||!stubParam.equals("ThrowExceptionStub.throwException")) {
            try {
                return pjp.proceed();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        throw new RuntimeException("打桩故意抛出的异常");
    }
}
