package com.java8.learn;

@FunctionalInterface
public interface MyCalcutor<T,R> {
    public R getValue(T t1, T t2);
}
