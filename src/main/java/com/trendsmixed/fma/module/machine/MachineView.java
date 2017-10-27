package com.trendsmixed.fma.module.machine;

import com.trendsmixed.fma.module.workcenter.WorkCenterView;
import com.trendsmixed.fma.utility.PageView;

public class MachineView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface EnergyRate {
    }

    public interface ControlPoint {

    }

    public interface All extends Id, Code, Name, EnergyRate, PageView.All {

    }

    public interface AllAndWorkCenterAll extends All, ControlPoint, WorkCenterView.All {

    }

    public interface ItemMachine {

    }

}
