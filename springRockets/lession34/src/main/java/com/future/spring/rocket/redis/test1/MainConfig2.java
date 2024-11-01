package com.future.spring.rocket.redis.test1;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@ComponentScan
@EnableCaching
public class MainConfig2 {

    @Bean
    public CacheManager cacheManager() throws IOException {
        RedissonSpringCacheManager cacheManager = new RedissonSpringCacheManager(this.redissonClient());
        cacheManager.setCacheNames(Arrays.asList("foo"));
        return cacheManager;
    }

    @Bean
    public RedissonClient redissonClient() throws IOException {
        InputStream in = MainConfig2.class.getResourceAsStream("/redis.yml");
        Config config = Config.fromYAML(in);
        return Redisson.create(config);
    }
}
