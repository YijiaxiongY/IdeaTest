package com.wangwenjun.guava.Concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class BucketTest {
    public static void main(String[] args) {
        final Bucket bucket = new Bucket();
        final AtomicInteger DATA_CREATOR = new AtomicInteger(0);

        IntStream.range(0,5).forEach(i->{
            new Thread(()->{
                for(;;){
                    int data = DATA_CREATOR.getAndIncrement();
                    bucket.submit(data);

                    try {
                        TimeUnit.MILLISECONDS.sleep(200L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });
        IntStream.range(0,5).forEach(i->{
            new Thread(()->{
                for(;;){
                   bucket.takeThenConsume(x-> System.out.println(Thread.currentThread()+"w"+x));


                }
            }).start();
        });
    }
}
