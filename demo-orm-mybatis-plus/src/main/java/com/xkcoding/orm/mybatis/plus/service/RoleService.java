package com.xkcoding.orm.mybatis.plus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xkcoding.orm.mybatis.plus.entity.Role;
import org.springframework.scheduling.annotation.Async;

/**
 * <p>
 * <a href="RoleService.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/3/15 15:59
 */
public interface RoleService extends IService<Role> {
    void insertTest(Role item);

    @Async
    Object hello();

    boolean testStub();
}
