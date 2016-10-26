package com.trendsmixed.fma.jsonView;

public class ControlPointView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface WorkCenter {
    }

    public static interface All extends Id, Code, Name {
    }

    public static interface AllAndWorkCenterAll extends All, WorkCenter, WorkCenterView.All {
    }

    public static interface AllAndWorkCenterAllAndCostCenterAllAndSectionAll extends All, WorkCenter, WorkCenterView.AllAndCostCenterAll, CostCenterView.AllAndSectionAll {

    }

}
