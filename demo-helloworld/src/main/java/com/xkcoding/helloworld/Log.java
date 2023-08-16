package com.xkcoding.helloworld;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * <p>
 * <a href="Log.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2022/12/23 13:58
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
}
