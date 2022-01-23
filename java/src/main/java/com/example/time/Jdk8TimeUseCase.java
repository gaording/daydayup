package com.example.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.*;
import java.util.Locale;
import java.util.Set;

/**
 * @program: daydayup
 * @date: 2022/1/23
 * @author: gaorunding1
 * @description: jdk8time api使用
 **/
public class Jdk8TimeUseCase {
    public static void main(String[] args) {
        testPeriod();
        testDuration();
    }

    /**
     * localDate初始化
     */
    public static void testLocalDateInit(){
        LocalDate localDate1 = LocalDate.of(2015, 02, 20);
        System.out.println(localDate1);
        LocalDate localDate2=LocalDate.parse("2015-02-20");
        System.out.println(localDate2);
        LocalDate localDate3=LocalDate.parse("20150220", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(localDate3);
    }

    /**
     * localDate计算plus、minus、leap、dayOfWeek
     */
    public static void testLocalDateCal(){
        LocalDate tomorrow=LocalDate.now().plusDays(1);
        System.out.println(tomorrow);
        LocalDate previousMonthSameDay=LocalDate.now().minus(1, ChronoUnit.MONTHS);
        System.out.println(previousMonthSameDay);
        //展示周几
        DayOfWeek sunday=LocalDate.parse("2016-06-12").getDayOfWeek();
        System.out.println(sunday.getDisplayName(TextStyle.FULL, Locale.CHINA));
        int twelve=LocalDate.parse("2016-06-12").getDayOfMonth();
        System.out.println(twelve);
        //判断是不是闰年
        boolean leapYear = LocalDate.now().isLeapYear();
        System.out.println(leapYear);
    }

    /**
     * localDate大小比较
     */
    public static void testLocalDateCompare(){
        boolean notBefore = LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11"));
        System.out.println(notBefore);
        boolean after = LocalDate.parse("2016-06-12").isAfter(LocalDate.parse("2016-06-11"));
        System.out.println(after);
    }

    /**
     * 每天零时，每月第一天
     */
    public static void testLocalDateHead(){
        LocalDateTime beginningOfDay = LocalDate.parse("2016-06-12").atStartOfDay();
        System.out.println(beginningOfDay);
        LocalDate monthFirstDay = LocalDate.parse("2016-06-12").with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(monthFirstDay);
    }


    /**
     * localTime
     */
    public static void testLocalTime(){
        LocalTime sixThirty=LocalTime.parse("06:30");
        System.out.println(sixThirty);
        LocalTime sevenThirty=sixThirty.plusHours(1);
        System.out.println(sevenThirty);
        int six=sixThirty.getHour();
        boolean isBefore=sixThirty.isBefore(sevenThirty);
        System.out.println(isBefore);
        LocalTime maxTime=LocalTime.MAX;
        System.out.println(maxTime);
    }

    /**
     * localDateTime
     */
    public static void testLocalDateTime(){
        LocalDateTime localDateTime = LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);
        System.out.println(localDateTime);
        LocalDateTime parse = LocalDateTime.parse("2015-02-20T06:30:00");
        System.out.println(parse);
        LocalDateTime localDateTime1 = localDateTime.plusDays(1);
        System.out.println(localDateTime1);
        LocalDateTime localDateTime2 = localDateTime.minusHours(2);
        System.out.println(localDateTime2);
        Month month = localDateTime.getMonth();
        System.out.println(month.getDisplayName(TextStyle.FULL,Locale.CHINA));
    }

    /**
     * zoneId
     */
    public static void testZoneId(){
        ZoneId zoneId=ZoneId.of("Asia/Shanghai");
        System.out.println(zoneId);
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);
        ZonedDateTime zonedDateTime=ZonedDateTime.of(LocalDateTime.now(),zoneId);
        System.out.println(zonedDateTime);
        zonedDateTime=ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Asia/Shanghai]");
        System.out.println(zonedDateTime);
        LocalDateTime localDateTime=LocalDateTime.of(2015,Month.FEBRUARY,20,06,30);
        ZoneOffset offset=ZoneOffset.of("+02:00");
        OffsetDateTime offsetByTwo = OffsetDateTime.of(localDateTime, offset);
        System.out.println(offsetByTwo);
    }

    /**
     * period
     */
    public static void testPeriod(){
        LocalDate initialDate=LocalDate.parse("2007-05-10");
        LocalDate finalDate=initialDate.plus(Period.ofDays(5));
        int five=Period.between(initialDate,finalDate).getDays();
        System.out.println(five);
        long fiveL=ChronoUnit.DAYS.between(initialDate,finalDate);
        System.out.println(fiveL);
    }

    /**
     * period
     */
    public static void testDuration(){
        LocalTime initialTime=LocalTime.of(6,30,0);
        LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));
        long seconds = Duration.between(initialTime, finalTime).getSeconds();
        System.out.println(seconds);
        long thirty=ChronoUnit.SECONDS.between(initialTime,finalTime);
        System.out.println(thirty);
    }

    /**
     * 时间调节器使用
     */
    public static void testAdjust(){
        LocalDate localDate=LocalDate.now();
        LocalDate nextSunday=localDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(nextSunday);
        LocalDate lastDayOfMonth=localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDayOfMonth);
    }

    /**
     * 自定义时间调节器
     */
    public static void testCustomAdjust(){
        LocalDate localDate=LocalDate.now();
        TemporalAdjuster temporalAdjuster=t->t.plus(Period.ofDays(14));
        LocalDate day = localDate.with(temporalAdjuster);
        System.out.println(day);

        TemporalAdjuster nextWorkingDayAdjuster=TemporalAdjusters.ofDateAdjuster(date->{
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            int daysToAdd;
            if (dayOfWeek==DayOfWeek.FRIDAY){
                daysToAdd=3;
            }else if (dayOfWeek==DayOfWeek.SATURDAY){
                daysToAdd=2;
            }else {
                daysToAdd=1;
            }
            return date.plusDays(daysToAdd);
        });
        LocalDate nextWorkingDay = localDate.with(nextWorkingDayAdjuster);
        System.out.println(nextWorkingDay);

        TemporalAdjuster customAdjuster= temporal -> {
            DayOfWeek dayOfWeek = DayOfWeek.from(temporal);
            int daysToAdd;
            switch (dayOfWeek){
                case FRIDAY:daysToAdd=3;break;
                case SATURDAY:daysToAdd=2;break;
                default:daysToAdd=1;
            }
            return temporal.plus(Period.ofDays(daysToAdd));
        };
        nextWorkingDay = localDate.with(customAdjuster);
        System.out.println(nextWorkingDay);
    }


}
