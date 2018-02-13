package com.trendsmixed.fma.dao.view;

import com.trendsmixed.fma.module.controlpoint.ControlPointView;

public class ManpowerSummaryView {

    public interface ControlPoint extends ControlPointView.AllAndControlPointTypeAllAndWorkCenterAllAndCostCenterAllAndSectionAll {
    }

    public interface Count {
    }

    public interface All extends Count, ControlPoint {
    }

}
