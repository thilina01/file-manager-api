package com.trendsmixed.fma.module.toolbreakdown;

import com.trendsmixed.fma.module.tool.ToolView;

public class ToolBreakdownView {

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

	public static interface Tool extends ToolView.All {
	}

	public static interface LossReason {
	}

	public static interface All
			extends Id, Date, Duration, BreakdownTime, RecoveryTime, BreakdownNumber, Description, Tool {

	}

}
