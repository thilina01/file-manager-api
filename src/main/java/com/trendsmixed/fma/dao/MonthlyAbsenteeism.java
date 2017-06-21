package com.trendsmixed.fma.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthlyAbsenteeism {

    String month,source;
    double absenteeism,target;

}
