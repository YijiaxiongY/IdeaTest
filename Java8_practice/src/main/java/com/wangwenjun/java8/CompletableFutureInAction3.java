package com.wangwenjun.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureInAction3 {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2, r->{
            Thread t = new Thread(r);
            t.setDaemon(false);
            return t;
        });
       /* CompletableFuture .supplyAsync(CompletableFutureInAction::get,executor).thenApply(CompletableFutureInAction3::multiply)
                .whenComplete((v,t)->{
                    Optional.of(v).ifPresent(System.out::println);

                });*/

        List<Integer> productId = Arrays.asList(1,2,3,4,5,6);
        Stream<CompletableFuture<Double>> completableFutureStream = productId.stream().map(i -> CompletableFuture.supplyAsync(() -> queryProduction(i), executor));
        Stream<CompletableFuture<Double>> completableFutureStream1 = completableFutureStream.map(future -> future.thenApply(CompletableFutureInAction3::multiply));
        List<Double> collect = completableFutureStream1.map(CompletableFuture::join).collect(Collectors.toList());
        for (Double d:collect) {
            System.out.println(d);

        }
    }

    private static  double multiply(double value){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return value*10d;
    }

    public static double queryProduction (int i){
        return CompletableFutureInAction.get();
    }

}
