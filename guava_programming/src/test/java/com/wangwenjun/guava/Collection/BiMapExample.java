package com.wangwenjun.guava.Collection;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

//根据value的值确定唯一性
public class BiMapExample {
    @Test
    public void test(){
        HashBiMap<String,String> biMap = HashBiMap.create();
        biMap.put("1","2");
        biMap.put("2","3");
        assertThat(biMap.containsKey("1"),is(true));
        System.out.println(biMap.size());
        BiMap<String, String> inverse = biMap.inverse();
        System.out.println(inverse);
       biMap.put("3","3");
        System.out.println(biMap);
    }
}
