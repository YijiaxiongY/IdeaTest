package com.wangwenjun.guava.Collection;

import com.google.common.collect.LinkedListMultimap;
import org.junit.Test;

import java.util.LinkedHashSet;

public class MultiMapsExample {
    @Test
    public void test(){

        LinkedListMultimap<String,String> multimap = LinkedListMultimap.create();
        multimap.put("1","1");
        multimap.put("1","2");
        System.out.println(multimap.size());
    }
}
