package com.xkcoding.orm.mybatis.plus.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.orm.mybatis.plus.entity.Role;
import com.xkcoding.orm.mybatis.plus.entity.User;
import com.xkcoding.orm.mybatis.plus.mapper.UserMapper;
import com.xkcoding.orm.mybatis.plus.service.RoleService;
import com.xkcoding.orm.mybatis.plus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * User Service
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-08 18:10
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleService roleService;

    @PostConstruct
    public void goTo(){
        roleService.hello();
    }



    @Async
    @Override
    public void test(){
        System.out.println("异步方法打印...");
    }

    @Transactional
    @Override
    public void test1(){
        String salt = IdUtil.fastSimpleUUID();
        User user = User.builder().name("testSave3").password(SecureUtil.md5("123456" + salt)).salt(salt).email("test").phoneNumber("17300000003").status(1).lastLoginTime(new DateTime()).build();

        userMapper.insert(user);
        List<Role> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Role role = new Role();
            role.setId(Long.valueOf(i));
            role.setName("ROLENAME"+ i);
            list.add(role);
        }
        list.forEach(item -> {

            try {
                roleService.insertTest(item);
            } catch (Exception e) {
                log.error("xxxx");
//                throw new RuntimeException(e);
            }
        });
    }



}
