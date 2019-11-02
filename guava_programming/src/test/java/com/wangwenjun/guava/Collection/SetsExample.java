package com.wangwenjun.guava.Collection;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SetsExample {
    @Test
    public void testCreate(){
        Set<Integer> set = Sets.newHashSet(1,2,3);
        assertThat(set.size(),equalTo(3));
        Set<Integer> set2 = Sets.newHashSet(set);
        assertThat(set2.size(),equalTo(3));
    }

    @Test
    public void testCartesianProduct(){
        //笛卡尔积
    }

    @Test
    public void testCombination(){
        HashSet<Integer> set = Sets.newHashSet(1,2,3);
        Set<Set<Integer>> combinations = Sets.combinations(set,2);
        combinations.forEach(System.out::println);
    }


    @Test
    public void testDiff(){
        HashSet<Integer> set1 = Sets.newHashSet(1,2,3);
        HashSet<Integer> set2 = Sets.newHashSet(1,4,6);
        Sets.SetView<Integer> diffres = Sets.difference(set2,set1);
        System.out.println(diffres);
        Sets.SetView<Integer> diffres1 = Sets.intersection(set2,set1);
        System.out.println(diffres1);
    }

    @Test
    public void testunionsection(){
        HashSet<Integer> set1 = Sets.newHashSet(1,2,3);
        HashSet<Integer> set2 = Sets.newHashSet(1,4,6);
        Sets.SetView<Integer> diffres = Sets.union(set2,set1);
        System.out.println(diffres);
    }
}
