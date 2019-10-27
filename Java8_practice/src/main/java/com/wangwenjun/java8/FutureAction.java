package com.wangwenjun.java8;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;


public class FutureAction {
    public static void main(String[] args) {
    /*    Future<String> future = invoke(()->{
            try {
                Thread.sleep(10000);
                return "I am finished";
            } catch (InterruptedException e) {
                return "error";
            }
        });
        System.out.println(future.get());

        //................
        while(!future.isDone()){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(future.get());
    }
*/
        Future<String> future = invoke(()->{
            try {
                Thread.sleep(10000);
                return "I am finished";
            } catch (InterruptedException e) {
                return "error";
            }
        });
        future.setCompletable(new Completable<String>() {
            @Override
            public void complete(String s) {
                System.out.println(s);
            }

            @Override
            public void exception(Throwable cause) {
                System.out.println("error");
                cause.printStackTrace();
            }
        }
        );

    }
    public static <T> Future<T> invoke(Callable<T> callable){
        AtomicReference<T> result = new AtomicReference<>();
        AtomicBoolean finished = new AtomicBoolean(false);
        Future<T> future = new Future<T>() {
            private Completable<T> completable;
            @Override
            public T get(){
                return result.get();
            }

            @Override
            public boolean isDone(){
                return finished.get();
            }

            @Override
            public void setCompletable(Completable<T> completable) {
                this.completable = completable;
            }

            @Override
            public Completable<T> getCompletable() {
                return completable;
            }
        };

        Thread t = new Thread(() -> {
            try {
                T value = callable.action();
                result.set(value);
                finished.set(true);
                if(future.getCompletable() != null){
                    future.getCompletable().complete(value);
                }
            }catch (Throwable cause){
                if(future.getCompletable() != null){
                    future.getCompletable().exception(cause);
                }
            }
        });
        t.start();
        return future;
    }

    private interface Future<T>{
        T get();
        boolean isDone();
        void setCompletable(Completable<T> completable);
        Completable<T> getCompletable();
    }


    private interface Callable<T>{
        T action();
    }


    public interface  Completable<T>{
        void complete(T t);
        void exception(Throwable cause);
    }
}
