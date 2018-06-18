package com.trendsmixed.fma.module.energyconsumption;

import com.trendsmixed.fma.module.location.LocationView;
import com.trendsmixed.fma.utility.PageView;

public class EnergyConsumptionView {

    public interface Id {
    }

    public interface Kwh {
    }

    public interface Kva {
    }

    public interface Cost {
    }

    public interface EffectiveMonth {
    }

    public interface Reference {
    }

    public interface Location extends LocationView.All {
    }

    public interface All extends Id, Kwh, Kva, Cost, EffectiveMonth, Reference, PageView.All {

    }

    public static interface AllAndLocation extends All, Location {
    }

}
