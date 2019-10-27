package com.wangwenjun.java8;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureInAction {
    private static Random r = new Random(System.currentTimeMillis());
    public static void main(String[] args) {
        CompletableFuture<Double> completableFuture = new CompletableFuture();
        new Thread(()->{
            double value = get();
            completableFuture.complete(value);
        }).start();

        completableFuture.whenComplete((v,t)->{
            Optional.ofNullable(v).ifPresent(System.out::println);
            Optional.ofNullable(t).ifPresent(x->x.printStackTrace());                }
        );
    }

    public static double get()  {
        try {
            Thread.sleep(r.nextInt(1000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return r.nextDouble();
    }
}
