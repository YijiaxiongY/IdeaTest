package com.wangwenjun.guava.Concurrent;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;

public class Bucket {
    private final ConcurrentLinkedQueue<Integer> container = new ConcurrentLinkedQueue<>();
    private final static int Bucket_limit = 1000;
    private final RateLimiter limiter = RateLimiter.create(10);
    private final Monitor offermoniter = new Monitor();
    private final Monitor pollmoiter = new Monitor();
    public void submit(int value){
        if(offermoniter.enterIf(offermoniter.newGuard(()->container.size() <Bucket_limit))){
            try{
                container.offer(value);
                System.out.println(Thread.currentThread()+"submit"+value+"current size"+container.size());
            }finally {
                offermoniter.leave();
            }
        }else{
            throw new IllegalStateException("The bucket is full");
        }
    }

    public void takeThenConsume(Consumer<Integer> consumer){
        if(pollmoiter.enterIf(pollmoiter.newGuard(()->!container.isEmpty()))){
            try{
                System.out.println(Thread.currentThread() +"waiting" +limiter.acquire());
                consumer.accept(container.poll());
            }finally {
                pollmoiter.leave();
            }
        }
    }
}
