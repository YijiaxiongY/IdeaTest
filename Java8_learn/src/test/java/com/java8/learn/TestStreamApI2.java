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
public class TestStreamApI2 {
    //中间操作
    /*

    筛选与切片
    filter-接受Lambda，从流中排除某些元素
    limit-截断流，使其元素不超过给定数量
    skip(n)-跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流，与limit(n)互补
    distinct-筛选，通过流所生成元素的hashcode()和equals()去除重复元素

    //映射
    map-接受Lambda,将元素转换成其他形式或读取信息，接受一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素，
    flatmap-接收一个函数作为参数，将流中的每个值都转换成另一个流，然后把所有流连接成一个流；


    //排序
    sorted() //自然排序
    sorted(Comparator()) //定制排序

    //查找与匹配
    allMatch--检查是否匹配所有元素
    anyMatch--检查至少匹配一个元素
    noneMatch--检查是否没有匹配所有元素
    findFirst--返回第一个元素
    findAny--返回当前流中的任何元素
    count--返回流中元素的个数
    max--返回流中最大值
    min--返回流中最小值
     */

    List<Employee> employees = Arrays.asList(
            new Employee(18,"张三")
    );

    @Test
    public void test5(){
        List<String> res = Arrays.asList("aaa","bbb","ccc","ddd");
        res.stream().sorted().forEach(System.out::println);

        employees.stream().sorted((e1,e2)->{
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else{
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });

//        res.stream(
    }


    @Test
    public void test4(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd");
        list.stream().map((str)->str.toUpperCase()).forEach(System.out::println);

        //采取Map映射
        Stream<Stream<Character>> sm = list.stream().map(TestStreamApI2 :: filterCharacter);
        sm.forEach((s)->s.forEach(System.out::println));

        //采取flatmap映射
        Stream<Character> stream = list.stream().flatMap(TestStreamApI2::filterCharacter);
        stream.forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for(Character ch : str.toCharArray()){
            list.add(ch);
        }
        return list.stream();

    }
    @Test
    public void test1(){
        //中间操作：不会执行任何操作
        Stream<Employee> stream = employees.stream().filter((e)->e.getAge()>15);
        //终止操作：一次性执行全部内容,惰性求值
        stream.forEach(System.out::println);


    }

    @Test
    public void test2(){
        employees.stream().filter((e) -> e.getAge() > 2).limit(2).forEach(System.out::println);
    }

    @Test
    public void test3(){
        employees.stream().filter((e)->e.getAge() > 2).skip(2).distinct().forEach(System.out::println);
    }



}
