package com.el.jichu.testlambda;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class TestLoclaDateFormat {

    //6.ZonedDate、ZonedTime、ZonedDateTime ： 带时区的时间或日期
    @Test
    public void test7(){
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(ldt);

        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("US/Pacific"));
        System.out.println(zdt);
    }

    @Test
    public void test6(){
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);
    }


    //5. DateTimeFormatter : 解析和格式化日期或时间
    @Test
    public void test5(){
//		DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss E");

        LocalDateTime ldt = LocalDateTime.now();
        String strDate = ldt.format(dtf);

        System.out.println(strDate);

        LocalDateTime newLdt = ldt.parse(strDate, dtf);
        System.out.println(newLdt);
    }

    //4. TemporalAdjuster : 时间校正器
    @Test
    public void test4(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);

        //自定义：下一个工作日
        LocalDateTime ldt5 = ldt.with((l) -> {
            LocalDateTime ldt4 = (LocalDateTime) l;

            DayOfWeek dow = ldt4.getDayOfWeek();

            if(dow.equals(DayOfWeek.FRIDAY)){
                return ldt4.plusDays(3);
            }else if(dow.equals(DayOfWeek.SATURDAY)){
                return ldt4.plusDays(2);
            }else{
                return ldt4.plusDays(1);
            }
        });

        System.out.println(ldt5);

    }


    @Test
    public  void test3(){
        Instant now = Instant.now();

        System.out.println("----------------");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant now1 = Instant.now();
        //Duration获取两个时间间隔
        System.out.println("耗费的时间是："+Duration.between(now1,now));

        System.out.println("-----------------------------------");

        LocalDate now2 = LocalDate.now();
        LocalDate of = LocalDate.of(2011, 1, 1);

        Period between = Period.between(of,now2 );
        System.out.println(between.getYears());
        System.out.println(between.getMonths());
        System.out.println(between.getDays());
    }

    @Test
    public void test2(){
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(now.getNano());
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        Instant instant = Instant.ofEpochSecond(5);
        System.out.println(instant);

    }
    //LocalDate LocalTime LocalDateTime
    @Test
    public void test1(){

        LocalDateTime now = LocalDateTime.now();

        System.out.println(now);

        LocalDateTime of = LocalDateTime.of(2016, 11, 21, 10, 10, 10);

        System.out.println(of);

        LocalDateTime localDateTime = of.plusYears(20);

        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = of.minusMonths(2);
        System.out.println(localDateTime1);

        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());

    }

}
