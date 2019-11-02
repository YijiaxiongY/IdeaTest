package com.wangwenjun.guava.Collection;

import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OrderingExampleTest {
    @Test
    public void testOrderNaturalByNullFirst(){
        List<Integer> list = Arrays.asList(1,5,null,3,8,2);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, Ordering.natural().nullsFirst());
        System.out.println(list);
    }

}
