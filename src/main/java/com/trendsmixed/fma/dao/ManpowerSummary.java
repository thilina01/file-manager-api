package com.trendsmixed.fma.dao;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.view.ManpowerSummaryView;
import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.section.Section;
import lombok.Data;

@Data
public class ManpowerSummary {

    @JsonView(ManpowerSummaryView.ControlPoint.class)
    ControlPoint controlPoint; 
    @JsonView(ManpowerSummaryView.Section.class)
    Section section; 
    @JsonView(ManpowerSummaryView.Count.class)
    private long count;
    
    public ManpowerSummary(ControlPoint controlPoint,  Long count) {
        super();
        this.controlPoint = controlPoint ;
        this.count = count != null ? count : 0;
    }
    
    public ManpowerSummary(Section section,  Long count) {
        super();
        this.section = section ;
        this.count = count != null ? count : 0;
    }
}
