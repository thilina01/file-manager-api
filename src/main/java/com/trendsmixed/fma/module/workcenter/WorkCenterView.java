package com.trendsmixed.fma.module.workcenter;

import com.trendsmixed.fma.module.costcenter.CostCenterView;
import com.trendsmixed.fma.utility.PageView;

public class WorkCenterView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface CostCenter {
    }

    public interface All extends Id, Code, Name, PageView.All {
    }

    public interface AllAndCostCenterAll extends All, CostCenter, CostCenterView.All {
    }

}
