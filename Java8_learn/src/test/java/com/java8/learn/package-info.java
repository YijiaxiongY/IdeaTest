package com.java8.learn;
/*
Lambda表达式的基础语法:Java中引入了一个新的操作符"->"该操作符为箭头操作符或Lambda
操作符，箭头操作符将Lambda表达式拆分成两部分;

左侧: Lambda 表达式中的参数列表
右侧: Lambda 表达式中所需执行的功能;


Lambda表达式书写方法:
一: 无参数，无返回值 ()->System.out.println("Hello world");
二: 有一个参数，并且无返回值: (x)-> System.out.println(x);
    有一个参数，小括号可以不写; x-> System.out.println(x);
三: 有多个参数，有返回值
四： 只有一条语句并且只有一个返回值;

左右一括号省；
左侧推断类型省;

二、Lambda 表达式需要"函数式接口的支持"
函数式接口: ，可以使用
 @FunctionalInterface 修饰，可以检查接口中只有一个抽象方法的接口称为函数式接口是否是函数式接口



 Java8新日期API

 //Instant: 时间戳(以Unix元年：1970年1月1日00:00:00 到某个时间之间的毫秒数；




 */