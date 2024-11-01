package com.future.spring.rocket.redis;

import com.future.spring.rocket.redis.test1.BaseService;
import com.future.spring.rocket.redis.test1.MainConfig2;
import org.junit.jupiter.api.Test;
import org.redisson.spring.cache.RedissonCache;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestRedisMain {

    @Test
    public void test0(){
        System.out.println("hi");
    }

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        BaseService baseService = context.getBean(BaseService.class);
        System.out.println(baseService.listFoo());
        System.out.println(baseService.listFoo());
        {
            System.out.println(" ==> redis key list:");
            RedissonSpringCacheManager cacheManager = context.getBean(RedissonSpringCacheManager.class);
            RedissonCache foo = (RedissonCache) cacheManager.getCache("foo");
            foo.getNativeCache().keySet().stream().forEach(System.out::println);
        }
    }
}
