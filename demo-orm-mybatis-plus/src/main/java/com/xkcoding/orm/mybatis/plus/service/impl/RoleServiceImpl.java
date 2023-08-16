package com.xkcoding.orm.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.orm.mybatis.plus.entity.Role;
import com.xkcoding.orm.mybatis.plus.mapper.RoleMapper;
import com.xkcoding.orm.mybatis.plus.service.RoleService;
import com.xkcoding.stub.Stub4Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * <a href="RoleServiceImpl.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/3/15 15:59
 */
@Service
@Slf4j
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertTest(Role item) {
        if (item.getId().equals(5L)){
            throw new RuntimeException("报错了");
        }
        this.save(item);
    }

    @Async
    @Override
    public Object hello() {
        log.info("当前线程：" + Thread.currentThread().getName());
        return "service hello";
    }

    @Override
    @Stub4Test(paramKey = "testStub",stubBeanName = "stubTestBean")
    public boolean testStub() {
        return false;
    }
}
