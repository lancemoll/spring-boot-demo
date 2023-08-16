package com.xkcoding.stub;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * <p>
 * <a href="RTTrueStub.java"><i>View Source</i></a>
 * 返回trueStub
 * @author Conan.chen
 * Date: 2023/3/17 9:18
 */
@Slf4j
public class RTTrueStub implements Stub {

    @Override
    public Object stub(Object[] args, String stubParam, ProceedingJoinPoint pjp) {
        log.info("配置中心获取参数：{}", stubParam);
        if (stubParam == null || !stubParam.equals("RTTrueStub.skip")) {
            try {
                return pjp.proceed();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        log.info("打桩返回true", true);
        return true;
    }
}
