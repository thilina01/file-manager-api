package com.trendsmixed.fma.module.machine;

import com.trendsmixed.fma.module.workcenter.WorkCenterView;
import com.trendsmixed.fma.utility.PageView;

public class MachineView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface EnergyRate {
    }

    public static interface ControlPoint {

    }

    public static interface All extends Id, Code, Name, EnergyRate, PageView.All {

    }

    public static interface AllAndWorkCenterAll extends All, ControlPoint, WorkCenterView.All {

    }

    public static interface ItemMachine {

    }

}
