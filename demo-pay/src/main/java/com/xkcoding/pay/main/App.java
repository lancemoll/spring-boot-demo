package com.xkcoding.pay.main;

import com.xkcoding.pay.config.SimpleBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 * <a href="App.java"><i>View Source</i></a>
 *
 * @author elin.zhou
 * Date: 2023/4/23 14:30
 */
public class App {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("demo.xml");
    SimpleBean simpleBean = applicationContext.getBean(SimpleBean.class);
    simpleBean.send();
  }
}
