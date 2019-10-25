package com.wangwenjun.guava.utilitiesTest;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


import static com.google.common.collect.ImmutableMap.of;
import static java.util.stream.Collectors.joining;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class JoinerTest {
    private final List<String> stringList = Arrays.asList(
            "Google","Guava","Java"
    );

    private final List<String> stringListWithNullValues = Arrays.asList(
            "Google","Guava","Java",null
    );

    private final Map<String,String> stringMap = of("Hello","Guava","Java","Scala");

    @Test
    public void testJoinneron(){
        String result = Joiner.on("#").join(stringList);
        assertThat(result,equalTo( "Google#Guava#Java"));
    }

    @Test
    public void testJoinnerOnwithNullValues(){
        String result = Joiner.on("#").skipNulls().join(stringListWithNullValues);
        assertThat(result,equalTo( "Google#Guava#Java"));
    }

    @Test
    public void testJoinnerOnwithNullValue_butWithDefaultValue(){
        String result = Joiner.on("#").useForNull("Scala").join(stringListWithNullValues);
        assertThat(result,equalTo( "Google#Guava#Java#Scala"));
    }

    @Test
    public void testJoin_on_Append_To_StringBuilder(){
        StringBuilder sb = Joiner.on("#").useForNull("Scala").appendTo(new StringBuilder(),stringListWithNullValues);
        assertThat(sb.toString(),equalTo( "Google#Guava#Java#Scala"));
    }

//  用jdk8实现同等功能
    @Test
    public void testJoiningByStream(){
        stringListWithNullValues.stream().filter(item->item != null &&
                item.isEmpty()).collect(joining("#"));


    }

    @Test
    public void testJoiningByStreamWithDefaultValue(){
        String result = stringListWithNullValues.stream().map(
                item->item == null || item .isEmpty() ? "Scala":item).collect(joining("#"));
    }

    


}
