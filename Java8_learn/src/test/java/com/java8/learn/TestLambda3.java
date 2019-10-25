package com.java8.learn;

import org.junit.Test;

import java.nio.file.FileSystemLoopException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Java8内置的四大核心函数式接口
 *
 * Consumer<T>: 消费型接口 void accept();
 * Supplier<T>: 供给型接口 T get();
 * Function<T,R> : 函数型接口，R apply(T t);
 * Predicate<T> ：断言型接口，boolean test(T t);
 */
public class TestLambda3 {
   //消费型接口
    @Test
    public void test1(){
        happy(10000,(m)-> System.out.println("消费了"+m));
    }

    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }
   //供给型接口
   @Test
    public void test2(){
        getNumList(10,()->(int)(Math.random()*100));
   }

   public List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < num;i++){
            Integer n = sup.get();
            list.add(n);
        }
        return list;
   }

   //Function<T,R> 函数型接口:
   //处理字符串
    @Test
    public void test3(){
        String newStr = strHandler("\\ shangguigu",(str) -> str.toUpperCase());
        System.out.println(newStr);
    }
    public String strHandler(String str, Function<String,String> fun){
        return fun.apply(str);
    }

    //断言型接口
    @Test
    public void test4(){
        List<String> list = Arrays.asList("Hello","atguigu","Lambda","www","ok");
        filterStr(list,(str)->str.length() > 3);

    }
    //需求:将满足的字符串，
    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> stringList = new ArrayList<>();
        for(String str : list){
            if(pre.test(str)){
                stringList.add(str);
            }
        }
        return stringList;
    }

    /*
    归约 reduce(T identify,BinayOperator)/ reduce(Binaryoperator)--
    可以将流中元素反复结合起来，得到一个值，返回T；
    可以将流中元素反复结合起来，得到一个值，返回Optional<T>
     */
    List<Employee> employees = Arrays.asList(
            new Employee(18,"张三"),
             new Employee(18,"张三")
    );
    /*
    收集
     collect 将流转化为其他形式，
     接受一个Collector接口的实现，用于给Stream元素汇总的办法
     */
    @Test
    public void test5() {
        List<String> list =
                employees.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println("-------------------");

        Set<String> set = employees.stream().map(Employee::getName).collect(Collectors.toSet());

        LinkedHashSet<String>  ls = employees.stream().map(Employee::getName)
                .collect(Collectors.toCollection(LinkedHashSet::new));



    }

    @Test
    public void test6(){
        //总数
        Long count = employees.stream().collect(Collectors.counting());

        //平均值
        Double avg = employees.stream().collect(Collectors.averagingDouble(Employee::getAge));

        //总和
        Double sum = employees.stream().collect(Collectors.summingDouble(Employee::getAge));

        //最大值
        Optional<Employee> max = employees.stream().collect(Collectors.maxBy((e1,e2)->Integer.compare(e1.getAge(),e2.getAge())));
        System.out.println(max.get());

        //最小值
        Optional<Integer> min = employees.stream().map(Employee::getAge).collect(Collectors.minBy(Integer
                ::compare));
    }

    //分组
    @Test
    public void test7(){
       Map<Integer,List<Employee>> ml =
        employees.stream().collect(Collectors.groupingBy(Employee::getAge));
    }

    //多级分组
    @Test
    public void test8(){
        Map<Integer,Map<String, List<Employee>>> mls = employees.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.groupingBy((e) -> {
            if (((Employee) e).getAge() <= 35) {
                return "青年";
            } else if (((Employee) e).getAge() <= 50) {
                return "青年";
            } else {
                return "青年";
            }
        })));
    }


    //分区
    @Test
    public void test9(){
        Map<Boolean,List<Employee>> map = employees.stream().collect(Collectors.partitioningBy((e1)->e1.getAge()>18));

    }

    @Test
    public void test10(){
        DoubleSummaryStatistics dss = employees.stream().collect(Collectors.summarizingDouble(Employee::getAge));
        System.out.println(dss.getMax());
    }

    @Test
    public void test11(){
        String str = employees.stream().map(Employee::getName).collect(Collectors.joining());
        System.out.println(str);
    }


}
