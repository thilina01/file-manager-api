package com.trendsmixed.fma.module.delivery;

public class DeliveryView {

    public static interface Id {
    }

    public static interface DeliveryDate {
    }

    public static interface DeliverdQuantity {
    }

    public static interface Location {
    }

    public static interface SalesOrderItem {
    }

    public static interface All extends Id, DeliveryDate, DeliverdQuantity, Location {

    }

}
