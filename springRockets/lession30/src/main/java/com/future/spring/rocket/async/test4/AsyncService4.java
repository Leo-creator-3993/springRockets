package com.future.spring.rocket.async.test4;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
@Async
public class AsyncService4 {

    public void m1() {
        throw new IllegalArgumentException("无返回值异常,参数非法!");
    }

    public Future<String> m2() {
        throw new IllegalArgumentException("有返回值异常, 参数非法!");
    }
}
