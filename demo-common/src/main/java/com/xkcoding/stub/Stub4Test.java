package com.xkcoding.stub;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Stub4Test {
    /**
      * 参数key 会自动去配置中心拉取
      */
    String paramKey() default "";

    /**
      * 桩 原方法将被替换为桩，由桩执行并返回
      */
    String stubBeanName();

}
