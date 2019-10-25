package com.java8.learn;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class DateTime {


    //DateTimeFomatter: 格式化时间/日期
    @Test
    public void test6(){
        DateTimeFormatter
    }

    //TemporalAdjuster : 时间矫正器
    @Test
    public void test5(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);

        //自定义下一个工作日
        LocalDateTime ldt1 = ldt.with((l) ->{
           LocalDateTime ldt4 = (LocalDateTime)l;
           DayOfWeek dow = ldt4.getDayOfWeek();

           if(dow.equals(DayOfWeek.FRIDAY)){
               return ldt4.plusDays(3);
           }else if(dow.equals(DayOfWeek.SATURDAY)){
               return ldt4.plusDays(2);
           }else{
               return ldt4.plusDays(1);
           }
        });
        System.out.println(ldt1);

    }




    //3.duration 计算两个时间之间的间隔
    //Period 计算两个日期之间的间隔
    @Test
    public void test4(){
        LocalDate ld1 = LocalDate.of(2015,1,1);
        LocalDate ld2 = LocalDate.now();

        Period period = Period.between(ld1,ld2);
        System.out.println(period.toString());
        System.out.println(period.getYears());
        System.out.println(period.getDays());
        System.out.println(period.getMonths());
    }



    @Test
    public  void test3(){
        Instant in = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant ins2 = Instant.now();
        Duration duration = Duration.between(in,ins2);
        System.out.println(duration.toMillis());


        System.out.println("------------------");


    }

    @Test
    public void test(){
        Instant in = Instant.now(); //默认UTC时区
        System.out.println(in);

        OffsetDateTime odt = in.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

        System.out.println(in.toEpochMilli());

        Instant instant = Instant.ofEpochSecond(50);
        System.out.println(instant);
    }

    //1.LocalDate 2.LocalTime 3.LocalDateTime

    @Test
    public void test1(){
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);

        LocalDateTime dt2 = LocalDateTime.of(2015,10,19,13,22,33);
        System.out.println(dt2);

        LocalDateTime dt3 = dt.plusYears(2);
        System.out.println(dt3);


    }
}
