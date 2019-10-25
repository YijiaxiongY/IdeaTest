package com.java8.learn;

import com.sun.media.sound.SF2GlobalRegion;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 *1. 方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用"
 * （可以理解为方法引用是Lambda表达式的另外一种表现形式”)
 * 主要有三种语法格式:
 * 对象:: 实例方法名
 * 类:: 静态方法名
 * 类:: 实例方法名
 *
 * 注意:
 *  Lambda 体中调用方法的参数列表和返回值类型，要与函数式接口中抽象方法
 *  的函数列表与返回值类型一致；
 *  若Lambda 参数列表中的第一参数是 实例方法的调用者，
 *    而第二个参数是实例方法的参数时， 可以使用ClassName::method;
 * 2. 构造器引用
 *  ClassName::new
 *
 * 3.数组引用 / 集合引用
 * Type::new;
 *
 */
public class TestMethodRef {

    //数组引用
    @Test
    public void test7(){
        Function<Integer,String[]> fun = (x)->new String[x];
        //构造器引用方式
        Function<Integer,String[]> fun2 = String[]::new;
        fun2.apply(20);
    }

    //构造器引用
    @Test
    public void test5(){
        Supplier<Employee> sup = ()->new Employee();

        //构造器引用方式
        Supplier<Employee> sup2 = Employee::new;
        Function<Integer,Employee> fun2 = Employee::new;
        BiFunction<Integer,String,Employee> bfun = Employee::new;
    }

    //类:实例方法名
    @Test
    public void test4(){
        BiPredicate<String,String> bp = (x,y)-> x.equals(y);

        BiPredicate<String,String> bp2 = String::equals;
    }


    //类:静态方法名
    @Test
    public void test3(){
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
        Comparator<Integer> com1 = Integer::compare;
    }


    //对象：实例方法名
    @Test
    public void test1(){
        PrintStream ps = System.out;
        Consumer<String> con = (x)-> System.out.println(x);

        Consumer<String> con2 = ps::println;
    }

    @Test
    public void test2(){
        Employee emp = new Employee();
        Supplier<String> sup = ()->emp.getName();
        String str = sup.get();

        Supplier<String> sup2 = emp::getName;

    }

}
