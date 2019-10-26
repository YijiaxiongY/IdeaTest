package com.wangwenjun.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReference {
    public static void main(String[] args) {
        List<Apple> res = Arrays.asList(new Apple("green",150),new Apple("green",40));
        Function<String,Integer> f = Integer::parseInt;
        System.out.println(f.apply("123"));
        BiFunction<String,Long,Apple> f1 = Apple::new;
        System.out.println(f1.apply("red",10L));
        BiFunction<String,Integer,Character> f2 = String::charAt;
        Character character = f2.apply("hello", 2);
        System.out.println(character);

        String string = new String("Java");
        Function<Integer,Character> f3 = string::charAt;

        res.sort((o1,o2)->o1.getColor().compareTo(o2.getColor()));
        res.sort(Comparator.comparing(Apple::getColor));
    }

}
