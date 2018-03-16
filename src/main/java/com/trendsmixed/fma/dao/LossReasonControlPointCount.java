package com.trendsmixed.fma.dao;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.view.LossReasonControlPointCountView;
import com.trendsmixed.fma.dao.view.LossReasonSectionCountView;
import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.section.Section;
import lombok.Data;

@Data
public class LossReasonControlPointCount {

    @JsonView(LossReasonControlPointCountView.ControlPoint.class)
    ControlPoint controlPoint;
    @JsonView(LossReasonControlPointCountView.Count.class)
    private long count;

    public LossReasonControlPointCount(ControlPoint controlPoint, Long count) {
        this.controlPoint = controlPoint;
        this.count = count != null ? count : 0;
    }

}
