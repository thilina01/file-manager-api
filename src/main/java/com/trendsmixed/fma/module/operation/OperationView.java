package com.trendsmixed.fma.module.operation;

public class OperationView {

    public static interface Id {
    }

    public static interface PlannedQuantity {
    }

    public static interface ActualQuantity {
    }

    public static interface UnitWeight {
    }

    public static interface Loss {
    }

    public static interface Production {
    }

    public static interface Job {
    }

    public static interface OperationType {
    }

    public static interface ProductType {
    }

    public static interface All extends Id, PlannedQuantity, ActualQuantity, UnitWeight {
    }

}
