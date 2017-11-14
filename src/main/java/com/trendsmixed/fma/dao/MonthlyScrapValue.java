package com.trendsmixed.fma.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthlyScrapValue {

    String month;
    long unitValue, quantity;
    double scrap;

    public double getScrap() {
        return Math.round(scrap * 100) / 100.0;
    }
}
