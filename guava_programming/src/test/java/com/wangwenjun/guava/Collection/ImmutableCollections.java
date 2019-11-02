package com.wangwenjun.guava.Collection;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ImmutableCollections {
    @Test
    public void test(){
        ImmutableList<Integer> list = ImmutableList.of(1,2,3);
        assertThat(list,notNullValue());
        fail();
    }

    @Test
    public void testCopy(){
        Integer[] array = {1,2,3,4,5};
        ImmutableList.copyOf(ImmutableList.copyOf(array));
    }


    @Test
    public void testBuilder(){
        ImmutableList<Integer> list = ImmutableList.<Integer>builder()
                .add(1)
                .add(2,3,4).addAll(Arrays.asList(1)).build();
        System.out.println(list);
    }


    @Test
    public void testImmutableMap(){
        ImmutableMap<String,String> map = ImmutableMap.<String,String>builder().put("Oracle","12c").put("Mysql","5.7").build();

        System.out.println(map);
    }
}
