package com.wangwenjun.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FilterApple {
    public static List<Apple> findGreenApple(List<Apple> apples){
        List<Apple> list = new ArrayList<>();
        for(Apple apple : apples){
            if("green".equals(apple.getColor())){
                list.add(apple);
            }
        }
        return list;
    }

    public static List<Apple> findApple(List<Apple> apples,String color){
        List<Apple> list = new ArrayList<>();
        for(Apple apple : apples){
            if(color.equals(apple.getColor())){
                list.add(apple);
            }
        }
        return list;
    }


   public static interface AppleFilter{
        boolean filter(Apple apple);
   }

   public static List<Apple> findApple(List<Apple> apples, AppleFilter appleFilter){
        List<Apple> res = new ArrayList<>();
        for(Apple apple : apples){
            if(appleFilter.filter(apple)){
                res.add(apple);
            }
        }
        return res;
   }
//  具体实现的策略
   public static class findRightApple implements AppleFilter{

       @Override
       public boolean filter(Apple apple) {
           return false;
       }
   }

    public static void main(String[] args) {
        List<Apple> res = Arrays.asList(new Apple("green",150),new Apple("green",40));
//        使用匿名内部类
        List<Apple> list = findApple(res, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                if(apple.getWeight() < 50){
                    return true;
                }
                return  false;
            }
        });
//           使用Lambda表达式
        List<Apple> appleList = findApple(res, (Apple apple) -> {
            return apple.getWeight() < 150;
        });

        Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        });



    }


}
