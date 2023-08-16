package com.xkcoding.orm.mybatis.plus.config;

import com.xkcoding.stub.Stub;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * <p>
 * <a href="TestStub.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/3/21 14:53
 */
@Component("stubTestBean")
@Slf4j
public class TestStub implements Stub {
    @Override
    public Object stub(Object[] args, String stubParam, ProceedingJoinPoint pjp) {
        log.info("配置中获取参数：{}", stubParam);
        if (stubParam == null) {
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
