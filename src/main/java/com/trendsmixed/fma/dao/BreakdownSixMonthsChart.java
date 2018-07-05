package com.trendsmixed.fma.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Thilina
 */ 
@Data 
@AllArgsConstructor
public class BreakdownSixMonthsChart {

    private String month;
    private Number productionInMinut, breakdownInMinuts, breakdownCount, mtbfInHours, mttrInHours, mdt;

}
