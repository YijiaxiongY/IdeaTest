package com.wangwenjun.java8;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMap {
    public static void main(String[] args) {
        String [] words = {"Hello","World"};
        Stream<String[]> stringStream = Arrays.stream(words).map(w -> w.split(""));
        Stream<String> stream = stringStream.flatMap(Arrays::stream);
        stream.distinct().forEach(System.out::println);
    }


}
