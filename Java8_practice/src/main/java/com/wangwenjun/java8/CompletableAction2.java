package com.wangwenjun.java8;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class CompletableAction2 {

    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean finished = new AtomicBoolean(false);
        ExecutorService executor = Executors.newFixedThreadPool(2, r->{
            Thread t = new Thread(r);
            t.setDaemon(false);
            return t;
        });
        //executor.execute(()->System.out.println("----"));
        CompletableFuture .supplyAsync(CompletableFutureInAction::get,executor)
        .whenComplete((v,t)->{
            Optional.of(v).ifPresent(System.out::println);
            Optional.of(t).ifPresent(x->x.printStackTrace());
            finished.set(true);
        });
        System.out.println("------ I am block ----");
       /* while(!finished.get()){
            Thread.sleep(100000);
        }

        */

    }

}
