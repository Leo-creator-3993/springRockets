package com.future.spring.rocket.cache;

import com.future.spring.rocket.cache.test1.ArticleCacheService;
import com.future.spring.rocket.cache.test1.MainConfig;
import com.future.spring.rocket.common.util.OtherUtil;
import org.junit.jupiter.api.Test;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestCacheMain {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig.class);
        context.refresh();

        //第二次从缓存中获取了
        ArticleCacheService cacheService = context.getBean(ArticleCacheService.class);
        System.out.println(cacheService.list());
        System.out.println(cacheService.list());
        OtherUtil.splitLinePrint();

        String result1 = cacheService.getPage(1, 10);
        String result2 = cacheService.getPage(1, 10);
        System.out.println(result1);
        System.out.println(result2);

        String result3 = cacheService.getPage(2, 20);
        String result4 = cacheService.getPage(2, 20);
        System.out.println(result3);
        System.out.println(result4);
        OtherUtil.splitLinePrint();
        cachePrint(context);
        OtherUtil.splitLinePrint();
        System.out.println(cacheService.getById(1, true));
        System.out.println(cacheService.getById(1, false));
        System.out.println(cacheService.getById(1, true));
        System.out.println(cacheService.getById(1, false));
        OtherUtil.splitLinePrint();
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig.class);
        context.refresh();

        //第二次从缓存中获取了
        ArticleCacheService cacheService = context.getBean(ArticleCacheService.class);
        System.out.println(cacheService.findById(1L));
        System.out.println(cacheService.findById(1L));
        System.out.println(cacheService.findById(2L));
        System.out.println(cacheService.findById(3L));
        cachePrint(context);

    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig.class);
        context.refresh();

        ArticleCacheService cacheService = context.getBean(ArticleCacheService.class);
        cacheService.add(1L, "article42");
        cacheService.add(2L, "articleFoo");
        cacheService.add(3L, "articleLeo");

        System.out.println("调用 ==> findById");
        System.out.println(cacheService.findById(1L));
        System.out.println(cacheService.findById(2L));
        System.out.println(cacheService.findById(3L));
        cachePrint(context);
    }

    @Test
    public void test4() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig.class);
        context.refresh();

        ArticleCacheService cacheService = context.getBean(ArticleCacheService.class);
        System.out.println(cacheService.findById(1L));
        System.out.println(cacheService.findById(1L));
        cacheService.delete(1L);
        System.out.println(cacheService.findById(1L));
    }


    private void cachePrint(AnnotationConfigApplicationContext context) {
        System.out.println("==> 开始打印出缓存fooCache中的key列表");
        ConcurrentMapCacheManager cacheManager = context.getBean(ConcurrentMapCacheManager.class);
        ConcurrentMapCache concurrentMapCache = (ConcurrentMapCache)cacheManager.getCache("fooCache");
        concurrentMapCache.getNativeCache().keySet().stream().forEach(System.out::println);
    }
}
