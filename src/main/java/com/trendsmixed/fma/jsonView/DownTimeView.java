package com.trendsmixed.fma.jsonView;

public class DownTimeView {

    public static interface Id {
    }

    public static interface DownTimeDate {
    }

    public static interface Duration {
    }

    public static interface Reason {
    }

    public static interface Date {
    }

    public static interface Machine {
    }

    public static interface All extends Id, DownTimeDate, Duration, Reason,Date  {

    }

    public static interface AllAndMachineAll extends All, Machine, MachineView.All {

    }

}
