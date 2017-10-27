package com.trendsmixed.fma.module.controlpointmachine;

import com.trendsmixed.fma.module.controlpoint.ControlPointView;
import com.trendsmixed.fma.module.machine.MachineView;

public class ControlPointMachineView {

    public interface Id {
    }

    public interface ControlPoint extends ControlPointView.All {
    }

    public interface Machine extends MachineView.All {
    }

    public interface ControlPointAndMachine extends ControlPoint, Machine {
    }

    public interface IdAndControlPointAndMachine extends Id, ControlPoint, Machine {
    }

}
