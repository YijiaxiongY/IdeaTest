package com.wangwenjun.java8;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureInAction {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future  = executorService.submit(()->{
            try {
                Thread.sleep(10000L);
                return " I am finished";
            } catch (InterruptedException e) {
                return "I am error";
            }
        });
        String value = future.get();
        while(!future.isDone()){
            Thread.sleep(10);
        }
        System.out.println(future.get());
        System.out.println(value);
        executorService.shutdown();

    }


}
