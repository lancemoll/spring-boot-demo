package com.xkcoding.orm.mybatis.plus.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xkcoding.orm.mybatis.plus.SpringBootDemoOrmMybatisPlusApplicationTests;
import com.xkcoding.orm.mybatis.plus.entity.User;
import com.xkcoding.orm.mybatis.plus.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * User Service 测试
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-08 18:13
 */
@Slf4j
public class UserServiceTest extends SpringBootDemoOrmMybatisPlusApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserMapper userMapper;


    @Test
    public void test1(){
        userService.test1();
    }

    @Test
    public void test2(){
        System.out.println(roleService.testStub());
    }
//
//
//
//    @Test
//    public void testAsync() {
//
//        try {
//            log.info("开始执行同步插入方法");
//            String salt = IdUtil.fastSimpleUUID();
//            User testSave3 = User.builder().name("testSave3").password(SecureUtil.md5("123456" + salt)).salt(salt).email("testSave3@xkcoding.com").phoneNumber("17300000003").status(1).lastLoginTime(new DateTime()).build();
//            Thread.sleep(1000);
//
//            boolean save = userService.save(testSave3);
//            Assert.assertTrue(save);
//            log.debug("【测试id回显#testSave3.getId()】= {}", testSave3.getId());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            log.info("开始执行异步");
//            userService.test();
//        }
//    }
//    /**
//     * 测试Mybatis-Plus 新增
//     */
//    @Test
//    public void testSave() {
//        String salt = IdUtil.fastSimpleUUID();
//        User testSave3 = User.builder().name("testSave3").password(SecureUtil.md5("123456" + salt)).salt(salt).email("testSave3@xkcoding.com").phoneNumber("17300000003").status(1).lastLoginTime(new DateTime()).build();
//        boolean save = userService.save(testSave3);
//        Assert.assertTrue(save);
//        log.debug("【测试id回显#testSave3.getId()】= {}", testSave3.getId());
//    }
//
//    /**
//     * 测试Mybatis-Plus 批量新增
//     */
//    @Test
//    public void testSaveList() {
//        List<User> userList = Lists.newArrayList();
//        for (int i = 4; i < 14; i++) {
//            String salt = IdUtil.fastSimpleUUID();
//            User user = User.builder().name("testSave" + i).password(SecureUtil.md5("123456" + salt)).salt(salt).email("testSave" + i + "@xkcoding.com").phoneNumber("1730000000" + i).status(1).lastLoginTime(new DateTime()).build();
//            userList.add(user);
//        }
//        boolean batch = userService.saveBatch(userList);
//        Assert.assertTrue(batch);
//        List<Long> ids = userList.stream().map(User::getId).collect(Collectors.toList());
//        log.debug("【userList#ids】= {}", ids);
//    }
//
//    /**
//     * 测试Mybatis-Plus 删除
//     */
//    @Test
//    public void testDelete() {
//        boolean remove = userService.removeById(1L);
//        Assert.assertTrue(remove);
//        User byId = userService.getById(1L);
//        Assert.assertNull(byId);
//    }
//
//    /**
//     * 测试Mybatis-Plus 修改
//     */
//    @Test
//    public void testUpdate() {
//        User user = userService.getById(1L);
//        Assert.assertNotNull(user);
//        user.setName("MybatisPlus修改名字");
//        boolean b = userService.updateById(user);
//        Assert.assertTrue(b);
//        User update = userService.getById(1L);
//        Assert.assertEquals("MybatisPlus修改名字", update.getName());
//        log.debug("【update】= {}", update);
//    }
//
//    /**
//     * 测试Mybatis-Plus 查询单个
//     */
//    @Test
//    public void testQueryOne() {
//        User user = userService.getById(1L);
//        Assert.assertNotNull(user);
//        log.debug("【user】= {}", user);
//    }
//
//    /**
//     * 测试Mybatis-Plus 查询全部
//     */
//    @Test
//    public void testQueryAll() {
//        List<User> list = userService.list(new QueryWrapper<>());
//        Assert.assertTrue(CollUtil.isNotEmpty(list));
//        log.debug("【list】= {}", list);
//    }
//
//    /**
//     * 测试Mybatis-Plus 分页排序查询
//     */
//    @Test
//    public void testSetSql(){
//        LambdaUpdateWrapper<User> lambdaUpdate = Wrappers.lambdaUpdate(new User());
//        lambdaUpdate.eq(User::getId,1);
//        BigDecimal decimal = new BigDecimal("20");
//        lambdaUpdate.setSql("amount = amount - " + decimal);
//        userMapper.update(null,lambdaUpdate);
//
//    }
//
//    /**
//     * 初始化数据
//     */
//    private void initData() {
//        testSaveList();
//    }

}
