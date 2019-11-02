package com.wangwenjun.guava.Collection;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import org.junit.Test;

import javax.jnlp.IntegrationService;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class FluentIterableExample {
    private FluentIterable<String> build(){
        List<String> list = Lists.newArrayList("Alex","Wang","Guava","Scala");
        return FluentIterable.from(list);
    }
    @Test
    public void test(){
       FluentIterable<String>  fit = build();
       assertThat(fit.size(),equalTo(4));
       FluentIterable<String> fit1 = fit.filter(e -> e!= null && e.length() >=4 );
       assertThat(fit1.size(),equalTo(2));
    }


    @Test
    public void test1(){
        FluentIterable<String> fit = build();
        ArrayList<String> append  = Lists.newArrayList("Append");
        fit = fit.append(append);
        assertThat(fit.size(),equalTo(5));

    }

    @Test
    public void testMatch(){
        FluentIterable<String>  fit = build();
        boolean res = fit.allMatch(e -> e!= null && e.length() >= 4 );
        assertThat(res,equalTo(true));
        res = fit.anyMatch(e -> e!= null&&e.length() ==5);
        assertThat(res,equalTo(true));
        Optional<String> optional = fit.firstMatch(e->e!= null && e.length()==5);
         assertThat(optional.isPresent(),is(true));

    }

    @Test
    public void testLimit(){
        FluentIterable<String> fit = build();
        FluentIterable<String> limit = fit.limit(3);
        System.out.println(limit);
        assertThat(limit.contains("Scala"),is(false));
    }

    @Test
    public void testCopyIn(){
        FluentIterable<String> fit = build();
        List<String> list = Lists.newArrayList("Java");
        List<String> res  = fit.copyInto(list);
        assertThat(res.size(),equalTo(5));
    }


    @Test
    public void testCycle(){
        FluentIterable<String> fit = build();
        FluentIterable<String> cycle = fit.cycle().limit(20);
        cycle.forEach(System.out::println);

    }


    @Test
    public void testTransform(){
        FluentIterable<String> fit = build();
        fit.transform((e)->e.length()).forEach(System.out::println);
    }

    @Test
    public void testTransformAndConcat(){
        FluentIterable<String> fit = build();
        List<Integer> list = Lists.newArrayList(1);
        FluentIterable<Integer> fit1 = fit.transformAndConcat(e->list);
        fit1.forEach(System.out::println);
    }

    /**
     *
     */
    @Test
    public void testTransformAndConcatInAction(){
        List<Integer> res  = Lists.newArrayList(1,2);
        FluentIterable.from(res).transformAndConcat((e)->search(e)).forEach(System.out::println);
    }

    private List<Customer> search(int type){
        if(type == 1){
            return Lists.newArrayList(new Customer(type,"Alex"),new Customer(type,"Tina"));
        }else{
            return Lists.newArrayList(new Customer(type,"wang"));
        }
    }

    class Customer{
        final int type;
        final String name;
        Customer(int type,String name)
        {
            this.type = type;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "type=" + type +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    @Test
    public void testJoin(){
        FluentIterable<String> fit = build();
        String res = fit.join(Joiner.on(','));
        System.out.println(res);
    }



}

