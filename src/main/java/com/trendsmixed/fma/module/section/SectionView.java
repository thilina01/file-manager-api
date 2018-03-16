package com.trendsmixed.fma.module.section;

import com.trendsmixed.fma.module.controlpoint.ControlPointView;
import com.trendsmixed.fma.module.costcenter.CostCenterView;
import com.trendsmixed.fma.module.workcenter.WorkCenterView;
import com.trendsmixed.fma.utility.PageView;

public class SectionView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface MTBFTarget {
    }

    public interface MTTRTarget {
    }

    public interface MDTTarget {
    }

    public interface SectionType {
    }

    public interface CostCenter extends CostCenterView.All{
    }

    public interface All extends Id, Code, Name, MTBFTarget, MTTRTarget, MDTTarget, PageView.All {
    }

    public interface AllAndCostCenterAndWorkCenterAndControlPointProduction extends All,CostCenter,CostCenterView.AllAndWorkCenter, WorkCenterView.AllAndControlPoint, ControlPointView.AllAndProduction{
    }


}
