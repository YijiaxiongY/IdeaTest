package com.wangwenjun.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {

    }

    private static  Stream<String> createStreamFromCollection(){
        List<String> stringList =
                Arrays.asList("hello","alex","wangwenjun","world");
        return stringList.stream();
    }

    private static Stream<String> createStreamFromValues(){
        return Stream.of("hello","alex","wangwenjun","world");
    }

    private static Stream<String> createStreamFromArrays(){
        String[] strings = {"hello","alex","wangwenjun","world"};
        return Arrays.stream(strings);
    }

    private static Stream<String> createStreamFromFile(){
        Path path = Paths.get("c:\\File");
        try {
            Stream<String> files = Files.lines(path);
            return files;
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
    }


}
