/*
 * 描述： <描述>
 * 修改人： Dave.zhao
 * 修改时间： May 26, 2017
 * 项目： app-core
 */
package com.xkcoding.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MyWebMvcConfigurationSupport
 *
 * @author Dave.zhao
 * @version [版本号, May 26, 2017]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Configuration
public class MyWebMvcConfigurationSupport implements WebMvcConfigurer {
    @Bean
//    @ConditionalOnProperty(prefix="app.token", name="enabled", matchIfMissing = true)
    public MyHandlerInterceptor myHandlerInterceptor() {
        return new MyHandlerInterceptor();
    }



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myHandlerInterceptor()).addPathPatterns("/**");
    }

}
