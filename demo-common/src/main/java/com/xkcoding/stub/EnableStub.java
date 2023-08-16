package com.xkcoding.stub;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({StubAspect.class})
public @interface EnableStub {
}
