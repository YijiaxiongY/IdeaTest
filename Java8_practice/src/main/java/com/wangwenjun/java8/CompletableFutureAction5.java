package com.wangwenjun.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 *
 */
public class CompletableFutureAction5 {
    public static void main(String[] args) throws InterruptedException {
      /*  CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName() + "is running ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }).runAfterBoth(CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName() + "is running");
            return 2;
        }),()-> System.out.println("done"));*/


    /*  CompletableFuture.supplyAsync(()->{
          System.out.println("I am future 1");
          return CompletableFutureInAction.get();
      }).applyToEither(CompletableFuture.supplyAsync(()->{
          System.out.println("I am future 2");
          return CompletableFutureInAction.get();
      }),v->v*10).thenAccept(System.out::println);*/
/*

        CompletableFuture.supplyAsync(()->{
            System.out.println("I am future 1");
            return CompletableFutureInAction.get();
        }).acceptEither(CompletableFuture.supplyAsync(()->{
            System.out.println("I am future 2");
            return CompletableFutureInAction.get();
        }),System.out::println);*/


      /*  CompletableFuture.supplyAsync(()->{
            System.out.println("I am future 1");
            return CompletableFutureInAction.get();
        }).runAfterEither(CompletableFuture.supplyAsync(()->{
            System.out.println("I am future 2");
            return CompletableFutureInAction.get();
        }),()-> System.out.println("done"));

*/

        List<CompletableFuture<Double>> collect = Arrays.asList(1,2,3,4).stream().
                map(i-> CompletableFuture.supplyAsync(CompletableFutureInAction::get)).collect(Collectors.toList());
        /*CompletableFuture.allOf(collect.toArray(new CompletableFuture[collect.size()])).thenRun(()->{
            System.out.println("done");
        });*/

        CompletableFuture.anyOf(collect.toArray(new CompletableFuture[collect.size()])).thenRun(()->{
            System.out.println("done");
        });

        Thread.currentThread().join();

    }
}
