package com.xkcoding.pay.config;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * <p>
 * <a href="SystemStartEvent.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/5/9 10:39
 */
@Getter
public class SystemStartEvent extends ApplicationEvent {
  String source;
  /**
   * Create a new ApplicationEvent.
   *
   * @param source the object on which the event initially occurred (never {@code null})
   */
  public SystemStartEvent(String source) {
    super(source);
    this.source = source;
  }
}
