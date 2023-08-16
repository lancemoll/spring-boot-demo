package com.xkcoding.orm.mybatis.plus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xkcoding.orm.mybatis.plus.entity.User;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * User Service
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-08 18:10
 */
public interface UserService extends IService<User> {
    @Async
    void test();

    void test1();

//    Object hello();
}
