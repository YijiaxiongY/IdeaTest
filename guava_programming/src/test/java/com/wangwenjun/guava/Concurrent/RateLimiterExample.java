package com.wangwenjun.guava.Concurrent;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class RateLimiterExample {
    private static  final RateLimiter limiter = RateLimiter.create(0.5);

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        IntStream.range(0,10).forEach(i->
                service.submit(RateLimiterExample::testLimiter));
    }

    public static void testLimiter() {
        System.out.println(Thread.currentThread()+"waiting"+limiter.acquire());
    }



}
