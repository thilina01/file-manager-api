package com.trendsmixed.fma.module.energyconsumption;

import com.trendsmixed.fma.module.location.*;
import com.trendsmixed.fma.utility.PageView;

public class EnergyConsumptionView {

    public static interface Id {
    }

    public static interface Kwh {
    }

    public static interface Kva {
    }

    public static interface Cost {
    }

    public static interface EffectiveMonth {
    }

    public static interface Reference {
    }

    public static interface Location extends LocationView.All {
    }

    public static interface All extends Id, Kwh, Kva, Cost, EffectiveMonth, Reference, PageView.All {

    }

    public static interface AllAndLocation extends All, Location {
    }

}
