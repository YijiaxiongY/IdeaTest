package com.java8.learn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
 Stream
 1. 创建Stream

 2. 中间操作
 3. 终止操作

 */
public class TestStream {
    //创建Stream
    @Test
    public void test1() {
        //1.可以通过Collection 系列集合提供的stream() 或 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();
        Stream<String> stream = list.parallelStream();


        //2.通过Arrays中的静态方法stream() 获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream3 = Arrays.stream(emps);

        //3.通过Stream类中的静态方法Of()
        Stream<String> stream2 = Stream.of("aa", "bb","cc");

        //创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0,(x)->x+2);
        stream4.limit(10).forEach(System.out::println);

        //生成
        Stream.generate(()->Math.random()).limit(10).forEach(System.out::println);
    }

}
