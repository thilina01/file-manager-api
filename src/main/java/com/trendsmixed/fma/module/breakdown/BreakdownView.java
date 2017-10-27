package com.trendsmixed.fma.module.breakdown;

import com.trendsmixed.fma.module.machine.MachineView;

public class BreakdownView {

    public interface Id {
    }

    public interface Date {
    }

    public interface Duration {
    }

    public interface BreakdownTime {
    }

    public interface RecoveryTime {
    }

    public interface BreakdownNumber {
    }

    public interface Description {
    }

    public interface Machine extends MachineView.All {
    }

    public interface LossReason {
    }

    public interface All
            extends Id, Date, Duration, BreakdownTime, RecoveryTime, BreakdownNumber, Description, Machine {

    }

}
