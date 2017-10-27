package com.trendsmixed.fma.module.controlpoint;

import com.trendsmixed.fma.module.controlpointtype.ControlPointTypeView;
import com.trendsmixed.fma.module.costcenter.CostCenterView;
import com.trendsmixed.fma.module.workcenter.WorkCenterView;
import com.trendsmixed.fma.utility.PageView;

public class ControlPointView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface WorkCenter extends WorkCenterView.All {
    }

    public interface ControlPointType extends ControlPointTypeView.All {
    }

    public interface All extends Id, Code, Name, PageView.All {
    }

    public interface AllAndWorkCenterAll extends All, WorkCenter {
    }

    public interface AllAndControlPointTypeAllAndWorkCenterAllAndCostCenterAllAndSectionAll extends All,
            ControlPointType, WorkCenter, WorkCenterView.AllAndCostCenterAll, CostCenterView.AllAndSectionAll {
    }

}
