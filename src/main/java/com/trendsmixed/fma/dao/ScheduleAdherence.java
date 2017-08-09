package com.trendsmixed.fma.dao;

import java.util.Calendar;
import java.util.Date;

import lombok.Data;

@Data
public class ScheduleAdherence {

    String category;
    long actualTotal;
    long plannedTotal;
    long value;

    public ScheduleAdherence(String category, Long actualTotal, Long plannedTotal, Long value) {
        super();
        this.category = category != null ? category : "NA";
        this.actualTotal = actualTotal != null ? actualTotal : 0;
        this.plannedTotal = plannedTotal != null ? plannedTotal : 0;
        this.value = value != null ? value : 0;
    }

    public ScheduleAdherence(Date date, Long actualTotal, Long plannedTotal, Long value) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String category = cal.get(Calendar.DAY_OF_MONTH) + "";
        this.category = category != null ? category : "NA";
        this.actualTotal = actualTotal != null ? actualTotal : 0;
        this.plannedTotal = plannedTotal != null ? plannedTotal : 0;
        this.value = value != null ? value : 0;
    }

}
