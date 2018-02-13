package com.trendsmixed.fma.dao;

import java.util.Calendar;
import java.util.Date;

import lombok.Data;

@Data
public class EmployeeDailyCount {

    Date date;
    String day;
    long count;

    public EmployeeDailyCount(Date date, Long count) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String day = cal.get(Calendar.DAY_OF_MONTH) + "";
        this.day = day != null ? day : "NA";
        this.date = date;
        this.count = count != null ? count : 0;
    }

}
