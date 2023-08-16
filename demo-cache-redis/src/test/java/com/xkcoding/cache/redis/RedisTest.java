package com.xkcoding.cache.redis;

import com.xkcoding.cache.redis.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import javax.annotation.Resource;
import java.io.ObjectStreamConstants;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * <p>
 * Redis测试
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-15 17:17
 */
@Slf4j
public class RedisTest extends SpringBootDemoCacheRedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 测试 Redis 操作
     */
//    @Test
//    public void get() {
//        // 测试线程安全，程序结束查看redis中count的值是否为1000
//        ExecutorService executorService = Executors.newFixedThreadPool(1000);
//        IntStream.range(0, 1000).forEach(i -> executorService.execute(() -> stringRedisTemplate.opsForValue().increment("count", 1)));
//
//        stringRedisTemplate.opsForValue().set("k1", "v1");
//        String k1 = stringRedisTemplate.opsForValue().get("k1");
//        log.debug("【k1】= {}", k1);
//
//        // 以下演示整合，具体Redis命令可以参考官方文档
//        String key = "xkcoding:user:1";
//        redisCacheTemplate.opsForValue().set(key, new User(1L, "user1"));
//        // 对应 String（字符串）
//        User user = (User) redisCacheTemplate.opsForValue().get(key);
//        log.debug("【user】= {}", user);
//    }

    @Test
    public void get() {
        List<Long> list = List.of(111222L, 7067432113662280426L,
                                  111333L,
                                  533191499493482551L,
                                  544475203225329684L);
        list.stream().forEach(item -> {

            System.out.println( new JdkSerializationRedisSerializer(
                this.getClass().getClassLoader()).deserialize(new JdkSerializationRedisSerializer(
                this.getClass().getClassLoader()).serialize("outletAuthKey:" + String.valueOf(item))));
            redisTemplate.opsForValue().set("outletAuthKey:" + String.valueOf(item),new User(item,"a"));
        });

    }

    public static void main(String[] args) {
        System.out.println(ObjectStreamConstants.STREAM_MAGIC);
    }
    @Test
    public void get1() {
        List<Long> list = List.of(111222L, 7067432113662280426L,
                                  111333L,
                                  533191499493482551L,
                                  544475203225329684L);
        list.stream().forEach(item -> {
            User user = (User) redisTemplate.opsForValue().get("outletAuthKey:" + String.valueOf(item));
            System.out.println(user);
        });


    }
}
