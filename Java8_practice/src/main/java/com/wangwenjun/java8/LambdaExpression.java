package com.wangwenjun.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
Predicate
Consumer
Supplier
Function
 */
public class LambdaExpression {
    private static List<Apple> filter(List<Apple> apples, Predicate<Apple> predicate){
        List<Apple> result = new ArrayList<>();
        for(Apple a : apples){
            if(predicate.test(a)){
                result.add(a);
            }
        }
        return result;
    }



    public static void main(String[] args) {
        List<Apple> res = Arrays.asList(new Apple("green",150),new Apple("green",40));
        List<Apple> res1 = filter(res,apple->apple.getColor().equals("yee"));

    }
}
