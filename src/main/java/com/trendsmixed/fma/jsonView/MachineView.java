package com.trendsmixed.fma.jsonView;

public class MachineView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface EnergyRate {
    }

    public static interface WorkCenter {

    }

    public static interface All extends Id,Code,Name,EnergyRate {
        
    }
    public static interface AllAndWorkCenterAll extends All,WorkCenter,WorkCenterView.All{
        
    }

    public static interface ItemMachine {

     
    }
    
}
