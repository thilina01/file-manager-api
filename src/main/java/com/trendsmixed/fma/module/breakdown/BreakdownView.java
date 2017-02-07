package com.trendsmixed.fma.module.breakdown;

public class BreakdownView {

    public static interface Id {
    }

    public static interface Date {
    }

    public static interface Duration {
    }

    public static interface BreakdownNumber {
    }

    public static interface Description {
    }

    public static interface Machine {
    }

    public static interface LossReason {
    }
    public static interface All extends Id, Date, Duration, BreakdownNumber, Description, Machine {

    }

}
