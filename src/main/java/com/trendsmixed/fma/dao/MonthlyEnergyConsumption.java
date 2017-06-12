package com.trendsmixed.fma.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthlyEnergyConsumption {

    String month,location;
    double kwh,kva,cost;

}
