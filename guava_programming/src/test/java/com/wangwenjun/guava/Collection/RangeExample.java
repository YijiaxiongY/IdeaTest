package com.wangwenjun.guava.Collection;

import com.google.common.collect.BoundType;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeMap;
import org.junit.Test;

import java.util.NavigableMap;
import java.util.TreeMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class RangeExample {
    @Test
    public void test(){
        Range<Integer> closedRange = Range.closed(0,0);
        System.out.println(closedRange);
        assertThat(closedRange.contains(5),is(true));
        Range<Integer> closedRange1 = Range.open(0,9);
        Range<Integer> closedRange2 = Range.openClosed(0,9);
        Range<Integer> closedRange3 = Range.closedOpen(0,9);
    }

    @Test
    public void testGreaterThan(){
        Range<Integer> range = Range.greaterThan(10);
        assertThat(range.contains(10),is(true));
        assertThat(range.contains(Integer.MAX_VALUE),is(true));

    }


    @Test
    public void testNagiveMap(){
        TreeMap<String,Integer> comparableObjectTreeMap = Maps.newTreeMap();
        comparableObjectTreeMap.put("java",1);
        comparableObjectTreeMap.put("scala",2);
        NavigableMap<String, Integer> stringIntegerNavigableMap = Maps.subMap(comparableObjectTreeMap, Range.closed("avav", "java"));
        System.out.println(stringIntegerNavigableMap);
    }


    @Test
    public void testOtherMethod(){
        Range<Integer> atLeastRange = Range.atLeast(2);
        Range<Integer> integerRange = Range.lessThan(10);
        Range<Integer> integerRange1 = Range.atMost(5);
        System.out.println(Range.all());
        System.out.println(Range.downTo(10, BoundType.CLOSED));
        System.out.println(Range.upTo(10,BoundType.CLOSED));
    }

    @Test
    public void testRangeMap(){
        TreeRangeMap<Comparable, Object> comparableObjectTreeRangeMap = TreeRangeMap.create();
       comparableObjectTreeRangeMap.put(Range.closed(0,60),"E");
       comparableObjectTreeRangeMap.put(Range.closedOpen(60,90),"D");
    }
}
