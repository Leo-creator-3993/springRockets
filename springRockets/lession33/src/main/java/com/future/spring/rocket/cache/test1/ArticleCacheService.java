package com.future.spring.rocket.cache.test1;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@CacheConfig(cacheNames = "fooCache")
public class ArticleCacheService {

    private Map<Long,String> articleMap = new HashMap<>();

    @Cacheable()
    public List<String> list() {
        System.out.println("==> 获取文章列表");
        return Arrays.asList("article1", "article2", "article3");
    }

    @Cacheable(key = "#root.target.class.name+ '-' + #page + '-' + #pageSize")
    public String getPage(int page, int pageSize) {
        String msg = String.format("page-%s-pageSize-%s", page, pageSize);
        System.out.println("从db中获取数据:" + msg);
        return msg;
    }

    @Cacheable(key = "'getById'+#Id", condition = "#cache")
    public String getById(int id, boolean cache) {
        System.out.println(" ==> 获取Id 数据");
        return String.format("==> Spring缓存:%s", UUID.randomUUID());
    }

    @Cacheable(key = "'findById'+#id", unless = "#result==null")
    public String findById(long id) {
        this.articleMap.put(1L, "articleX");
        System.out.println("--- 获取文章Id ==> " + id);
        return this.articleMap.get(id);
    }

    @Cacheable(key = "'findById'+#id")
    public String add(long id, String content) {
        System.out.println("新增文章 ==> " + id);
        this.articleMap.put(id, content);
        return content;
    }

    @CacheEvict(key = "'findById'+#id")
    public void delete(long id) {
        System.out.println("删除文章 ==> " + id);
        this.articleMap.remove(id);
    }
}
