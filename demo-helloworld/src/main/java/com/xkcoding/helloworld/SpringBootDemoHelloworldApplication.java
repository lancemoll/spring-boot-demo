package com.xkcoding.helloworld;

import cn.hutool.core.util.StrUtil;
import com.xkcoding.test.LogSelector;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.core.GenericTypeResolver;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * <p>
 * SpringBoot启动类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-09-28 14:49
 */
@SpringBootApplication
@RestController
@Import(LogSelector.class)
public class SpringBootDemoHelloworldApplication {

    @Autowired
    UserService userService;

    @Autowired
    Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoHelloworldApplication.class, args);
    }

    /**
     * Hello，World
     *
     * @param who 参数，非必须
     * @return Hello, ${who}
     */
    @PostMapping ("/hello")
    public String sayHello(@RequestParam(required = false, name = "who") String who,HttpServletRequest req) throws InvocationTargetException, IllegalAccessException {
        String[] activeProfiles = environment.getActiveProfiles();
        String activeProfile = "";
        if (activeProfiles.length > 0){
            activeProfile = environment.getActiveProfiles()[0];
        }
        String userId = req.getParameter("userId");
        System.out.println(userId);
        if (StrUtil.isBlank(who)) {
            who = "World";
        }

        Class<?> targetClass = AopUtils.getTargetClass(userService);
        final AtomicReference<Method> annotatedMethod = new AtomicReference<Method>();
        ReflectionUtils.doWithMethods(targetClass, method -> {
            Annotation annotation = AnnotationUtils.findAnnotation(method, Log.class);
            if (annotation != null) {
                Assert.isNull(annotatedMethod.get(), "found more than one method on target class ["
                    + targetClass + "] with the annotation type [" + Log.class + "]");
                annotatedMethod.set(method);
            }
        });
        Method method = annotatedMethod.get();
        Object invoke = method.invoke(userService);

        return StrUtil.format("Hello, {}!", invoke);
    }

    @PostMapping("findUser")
    public String findUser(){
        return userService.findUserName();
    }
}
