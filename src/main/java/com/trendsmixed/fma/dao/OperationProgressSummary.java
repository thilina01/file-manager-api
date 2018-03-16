package com.trendsmixed.fma.dao;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.view.OperationProgressSummaryView;
import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.production.Production;
import com.trendsmixed.fma.module.section.Section;

public class OperationProgressSummary {

    @JsonView(OperationProgressSummaryView.ControlPoint.class)
    ControlPoint controlPoint;
    @JsonView(OperationProgressSummaryView.Section.class)
    Section section;
    @JsonView(OperationProgressSummaryView.Production.class)
    Production production;

    public OperationProgressSummary(Section section, ControlPoint controlPoint, Production production) {
        super();
        this.section = section ;
        this.controlPoint = controlPoint ;
        this.production = production ;
    }
}
