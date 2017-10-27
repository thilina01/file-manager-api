package com.trendsmixed.fma.module.toolbreakdown;

import com.trendsmixed.fma.module.tool.ToolView;

public class ToolBreakdownView {

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

    public interface Tool extends ToolView.All {
    }

    public interface LossReason {
    }

    public interface All
            extends Id, Date, Duration, BreakdownTime, RecoveryTime, BreakdownNumber, Description, Tool {

    }

}
