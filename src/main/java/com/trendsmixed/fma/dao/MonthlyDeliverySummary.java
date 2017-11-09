package com.trendsmixed.fma.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthlyDeliverySummary {

    String month;
    double plan, actual, percentage;

    public double getPercentage(){
        return Math.round(percentage*100)/100.0;
    }
}
