package com.trendsmixed.fma.jsonView;

public class WorkCenterView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface CostCenter {

    }
    public static interface IdAndCodeAndCostCenterIdAndCostCenterCodeAndCostCenterName extends Id,Code,CostCenter, CostCenterView.IdAndCodeAndName{

    }
    
    

}
