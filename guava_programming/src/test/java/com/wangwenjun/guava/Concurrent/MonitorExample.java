package com.wangwenjun.guava.Concurrent;

import com.google.common.util.concurrent.Monitor;
import org.checkerframework.checker.units.qual.A;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MonitorExample {
    /**
     *
     */


    public static void main(String[] args) {
//        final Sychronized syc = new Sychronized();
        final  MonitorGuard mg = new MonitorGuard();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (; ; ) {
                    int data = atomicInteger.getAndIncrement();
                    System.out.println(Thread.currentThread() + "offer" + data);
                    mg.offer(data);
                    try {
                        TimeUnit.MILLISECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (; ; ) {
                    int take = mg.take();
                    System.out.println(Thread.currentThread() + "take" + take);

                    try {
                        TimeUnit.MILLISECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }

    static class Sychronized {
        private final LinkedList<Integer> queue = new LinkedList<>();
        private final int Max = 10;

        public void offer(int value) {
            synchronized (queue) {
                while (queue.size() >= Max) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.addLast(value);
                queue.notifyAll();
            }
        }


        public int take() {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Integer value = queue.removeFirst();
                queue.notifyAll();
                return value;
            }

        }
    }


    static class MonitorGuard{
        private final LinkedList<Integer> queue = new LinkedList<>();
        private final int Max = 10;
        private final Monitor monitor = new Monitor();
        private final Monitor.Guard CAN_OFFER = monitor.newGuard(()->queue.size() < Max);
        private final Monitor.Guard CAN_TAKE = monitor.newGuard(()->!queue.isEmpty());


        public void offer(int value){
            try{
                monitor.enterWhen(CAN_OFFER);
                queue.addLast(value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                monitor.leave();
            }
        }

        public int take(){
             try{
                 monitor.enterWhen(CAN_TAKE);
                 return  queue.removeFirst();
             } catch (InterruptedException e) {
                 throw  new RuntimeException(e);
             } finally {
                 monitor.leave();
             }
        }
    }
}
