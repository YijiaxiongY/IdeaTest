package com.wangwenjun.guava.Collection;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListsExample {

    @Test
    public void test(){
        List<List<String>> res = Lists.cartesianProduct(
                Lists.newArrayList("1","2"),
                Lists.newArrayList("A","B")
        );
        System.out.println(res);
    }

    @Test
    public void transform(){
        List<String> res = Lists.newArrayList("guava","scala");
        Lists.transform(res,(e)->e.toUpperCase()).forEach(System.out::println);
    }

    @Test
    public void testNewArrayList(){
        List<String> res = Lists.newArrayListWithCapacity(10);
        res.add("a");
        List<String> res1 = Lists.newArrayListWithExpectedSize(2);
    }

    @Test
    public void testNewArrayListWithExpectedSize(){
       List<String> res =  Lists.newArrayListWithExpectedSize(5);
        System.out.println(res.size());
    }


    @Test
    public void testReverse(){
        List<String> list = Lists.newArrayList();
        list.add(null);

    }


    @Test
    public void testPartition(){
        List<String> list = Lists.newArrayList("1","2","3","4");
        List<List<String>> res = Lists.partition(list,2);
        System.out.println(res.get(0));
        System.out.println(res.get(1));
    }

}
