package com.trendsmixed.fma.module.controlpointmachine;

import com.trendsmixed.fma.module.controlpoint.ControlPointView;
import com.trendsmixed.fma.module.machine.MachineView;

public class ControlPointMachineView {

	public static interface Id {
	}

	public static interface ControlPoint extends ControlPointView.All {

	}

	public static interface Machine extends MachineView.All {

	}

	public interface ControlPointAndMachine extends ControlPoint, Machine {

	}

}
