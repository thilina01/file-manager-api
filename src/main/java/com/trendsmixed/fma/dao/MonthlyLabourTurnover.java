package com.trendsmixed.fma.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthlyLabourTurnover {

    String month,source;
    double turnover,target;

}
