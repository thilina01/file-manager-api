package com.trendsmixed.fma.module.breakdown;

import com.trendsmixed.fma.module.machine.MachineView;

public class BreakdownView {

    public static interface Id {
    }

    public static interface Date {
    }

    public static interface Duration {
    }

    public static interface BreakdownTime {
    }

    public static interface RecoveryTime {
    }

    public static interface BreakdownNumber {
    }

    public static interface Description {
    }

    public static interface Machine extends MachineView.All {
    }

    public static interface LossReason {
    }

    public static interface All
            extends Id, Date, Duration, BreakdownTime, RecoveryTime, BreakdownNumber, Description, Machine {

    }

}
