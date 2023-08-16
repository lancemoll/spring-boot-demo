package com.xkcoding.helloworld;

import org.springframework.stereotype.Service;

/**
 * <p>
 * <a href="UserServiceImpl.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2022/12/23 13:55
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    @Log
    public String findUserName() {
        return "张三";
    }
}
