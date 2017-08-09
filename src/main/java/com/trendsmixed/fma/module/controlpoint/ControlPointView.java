package com.trendsmixed.fma.module.controlpoint;

import com.trendsmixed.fma.module.controlpointtype.ControlPointTypeView;
import com.trendsmixed.fma.module.costcenter.CostCenterView;
import com.trendsmixed.fma.module.workcenter.WorkCenterView;
import com.trendsmixed.fma.utility.PageView;

public class ControlPointView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface WorkCenter extends WorkCenterView.All {
    }

    public interface ControlPointType extends ControlPointTypeView.All {
    }

    public static interface All extends Id, Code, Name, PageView.All {
    }

    public static interface AllAndWorkCenterAll extends All, WorkCenter {
    }

    public static interface AllAndControlPointTypeAllAndWorkCenterAllAndCostCenterAllAndSectionAll extends All,
            ControlPointType, WorkCenter, WorkCenterView.AllAndCostCenterAll, CostCenterView.AllAndSectionAll {
    }

}
