package com.xkcoding.pay.main;

import com.xkcoding.pay.config.SystemStartEvent;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * <p>
 * <a href="TestApplicationContextIni.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/5/9 10:38
 */
public class TestApplicationContextIni implements ApplicationContextInitializer {
  @Override
  public void initialize(ConfigurableApplicationContext applicationContext) {
    System.out.println("啓動中。。。");
//    applicationContext.publishEvent(new SystemStartEvent("xx"));
  }
}
