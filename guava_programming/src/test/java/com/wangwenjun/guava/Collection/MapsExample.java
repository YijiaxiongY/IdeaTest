package com.wangwenjun.guava.Collection;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.Immutable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

public class MapsExample {
    @Test
    public void test(){
        ArrayList<String> valueList = Lists.newArrayList("1", "2", "3");
        ImmutableMap<String,String> map = Maps.uniqueIndex(valueList, v->v+"_key");
        System.out.println(map);
        Map<String,String> map2 = Maps.asMap(Sets.newHashSet("1","2","3"),k->k+"value");
        System.out.println(map2);

    }

    @Test
    public void testTransform(){
        Map<String,String> map2 = Maps.asMap(Sets.newHashSet("1","2","3"),k->k+"_value");
        Map<String,String> newMap = Maps.filterKeys(map2,k->Lists.newArrayList(1,2).contains(k));
    }


    @Test
    public void testMultiMaps(){

    }
    
}
