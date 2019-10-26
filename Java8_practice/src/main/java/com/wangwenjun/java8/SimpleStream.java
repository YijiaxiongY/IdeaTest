package com.wangwenjun.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SimpleStream {
    public static void main(String[] args) {
        //have a dish list(menu)
        List<Apple> apples = Arrays.asList(new Apple("green",150),new Apple("black",40));
//        try {
//            Thread.sleep(1000000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        apples.parallelStream().filter((apple)->{
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return apple.getWeight()<200;

        }).
                sorted(Comparator.comparing(Apple::getColor)).map(Apple::getColor).
                forEach(System.out::println);



    }
}
