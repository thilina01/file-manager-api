package com.trendsmixed.fma.module.workcenter;

import com.trendsmixed.fma.module.costcenter.CostCenterView;
import com.trendsmixed.fma.utility.PageView;

public class WorkCenterView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface CostCenter {
    }

    public static interface All extends Id, Code, Name, PageView.All {
    }

    public static interface AllAndCostCenterAll extends All, CostCenter, CostCenterView.All {
    }

}
