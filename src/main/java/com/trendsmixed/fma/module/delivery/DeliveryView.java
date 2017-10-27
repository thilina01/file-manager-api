package com.trendsmixed.fma.module.delivery;

public class DeliveryView {

    public interface Id {
    }

    public interface DeliveryDate {
    }

    public interface DeliverdQuantity {
    }

    public interface Location {
    }

    public interface SalesOrderItem {
    }

    public interface All extends Id, DeliveryDate, DeliverdQuantity, Location {

    }

}
