package com.xkcoding.pay.config;

import org.springframework.context.event.EventListener;

/**
 * <p>
 * <a href="SystemListener.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/5/9 10:41
 */
public class SystemListener {

  @EventListener
  public void start(SystemStartEvent systemStartEvent) {
    System.out.println("监听到系统启动的发布事件：" +systemStartEvent.getSource());
  }
}
