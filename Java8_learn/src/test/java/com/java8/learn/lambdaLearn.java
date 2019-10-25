package com.java8.learn;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;

public class lambdaLearn {
    Runnable r = ()-> System.out.println("Hello idea");

    @Test
    public  void test1(){
        Consumer<String> con = x -> System.out.println(x);
        con.accept("我大尚硅谷测试");
    }

    @Test
    public void test2(){
        Comparator<Integer> com = (x,y) ->
        {
            System.out.println(x+"--"+y);
            return Integer.compare(x,y);
        };
    }


    @Test
    public void test4(){
        Comparator<Integer> com = (x,y) -> Integer.max(x,y);
    }

    @Test
    public void test5(){
//        ThreadLocal
        String [] strs = {"aaa","bbb","cccc"};
    }

    //需求：
//    对一个数进行运算
    @Test
    public void test6(){
        Integer num =  operation(100, (x)-> x*x);
        System.out.println(num);

    }


    public Integer operation(Integer num, MyPredicate mp){
        return mp.getValue(num);
    }

    @Test
    public void testF(){
        String trimStr = strHandler("     shangguiguceshi",(str)->str.trim());
        System.out.println(trimStr);

        String upperStr = strHandler(trimStr,(e1)->e1.toUpperCase());
        System.out.println(upperStr);

        String s = strHandler(trimStr, (e3) -> e3.substring(2, 4));
        System.out.println(s);
    }


    //用于处理字符串
    public String strHandler(String str,MyFunction mf){
        return mf.getValue(str);
    }


    @Test
    public void test9(){
        op(10L,20L,(x,y)-> x*y);
        op(10L,20L,(x,y)-> x+y);
    }

    public void op(long l1,long l2,MyCalcutor<Long,Long> mf){
        System.out.println(mf.getValue(l1,l2));
    }



}
