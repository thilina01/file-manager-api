package com.trendsmixed.fma.jsonView;

public class WorkCenterView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface CostCenter {
    }

    public static interface All extends Id, Code {
    }

    public static interface AllAndCostCenterAll extends All, CostCenter, CostCenterView.All {
    }

}
