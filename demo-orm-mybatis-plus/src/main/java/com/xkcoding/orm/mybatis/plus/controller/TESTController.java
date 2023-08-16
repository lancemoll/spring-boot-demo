package com.xkcoding.orm.mybatis.plus.controller;

import com.xkcoding.orm.mybatis.plus.config.LoginExcludeUrl;
import com.xkcoding.orm.mybatis.plus.config.YamlConfig;
import com.xkcoding.orm.mybatis.plus.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * <a href="TESTController.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/3/21 15:03
 */
@RestController
public class TESTController {
    @Autowired
    private RoleService roleService;
  @Autowired
  private LoginExcludeUrl loginExcludeUrl;
  @Autowired
  private YamlConfig yamlConfig;

    @RequestMapping("testStub")
    public boolean test1(){
      loginExcludeUrl.getExclude("app1");
      return roleService.testStub();
    }
}
