package com.trendsmixed.fma.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthlyScheduleAdherence {

    String month;
    long actualTotal;
    long plannedTotal;
    double adherence;


    public double getAdherence(){
        return Math.round(adherence*100)/100.0;
    }
}
