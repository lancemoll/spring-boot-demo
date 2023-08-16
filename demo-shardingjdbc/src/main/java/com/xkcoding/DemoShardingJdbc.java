package com.xkcoding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan("com.xkcoding.sharding.jdbc.mapper")
public class DemoShardingJdbc
{
    public static void main( String[] args )
    {
        SpringApplication.run(DemoShardingJdbc.class, args);
    }
}
