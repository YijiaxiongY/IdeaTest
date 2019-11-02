package com.wangwenjun.guava.utilitiesTest;

import com.google.common.base.*;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import org.junit.Test;
import sun.security.ec.point.ProjectivePoint;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/*

 */
public class SpliterTest {
    @Test
    public void testSplitOnSplit(){
        List<String> result = Splitter.on("|").splitToList("hello|world");
       assertThat(result,notNullValue());
       assertThat(result.size(),equalTo(2));
       assertThat(result.get(0),equalTo("hello"));
       assertThat(result.get(1),equalTo("world"));
    }

    @Test
    public void testSplit_on_Split(){

    }

}
