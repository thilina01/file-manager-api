package com.trendsmixed.fma.jsonView;

public class DeliveryView {

    public static interface Id {
    }

    public static interface DeliveryDate {
    }

    public static interface DeliveredQuantity {
    }

    public static interface Location {
    }
    public static interface All extends Id,DeliveryDate,DeliveredQuantity,Location{
        
    }
}
