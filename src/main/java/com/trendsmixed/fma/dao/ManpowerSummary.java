package com.trendsmixed.fma.dao;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.view.ManpowerSummaryView;
import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import lombok.Data;

@Data
public class ManpowerSummary {

    @JsonView(ManpowerSummaryView.ControlPoint.class)
    ControlPoint controlPoint; 
    @JsonView(ManpowerSummaryView.Count.class)
    private long count;
    
    public ManpowerSummary(ControlPoint controlPoint,  Long count) {
        super();
        this.controlPoint = controlPoint ;//!= null ? controlPoint : "NA";
        this.count = count != null ? count : 0;
    }
}
