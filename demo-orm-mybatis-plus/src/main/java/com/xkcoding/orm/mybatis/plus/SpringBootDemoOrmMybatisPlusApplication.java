package com.xkcoding.orm.mybatis.plus;

import com.xkcoding.orm.mybatis.plus.config.LoginExcludeUrl;
import com.xkcoding.orm.mybatis.plus.spi.SpiService;
import com.xkcoding.stub.EnableStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * <p>
 * 启动器
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-08 16:48
 */
@SpringBootApplication(scanBasePackages = "com.xkcoding.orm.mybatis.plus")
@EnableStub
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringBootDemoOrmMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoOrmMybatisPlusApplication.class, args);
//        Iterator<SpiService> providers = Service.providers(SpiService.class);
//        ServiceLoader<SpiService> load = ServiceLoader.load(SpiService.class);

//        while(providers.hasNext()) {
//            SpiService ser = providers.next();
//            ser.execute();
//        }
//        System.out.println("--------------------------------");
//        Iterator<SpiService> iterator = load.iterator();
//        while(iterator.hasNext()) {
//            SpiService ser = iterator.next();
//            ser.execute();
//        }
    }
}
