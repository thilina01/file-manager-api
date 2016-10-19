package com.trendsmixed.fma.jsonView;

public class PurchaseOrderView {

    public static interface Id {
    }

    public static interface PoNumber {
    }

    public static interface OrderQty {
    }

    public static interface CustomerRequestedDate {
    }

    public static interface TrwConfirmedDate {
    }

    public static interface ActualDespatchDate {
    }

    public static interface Comments {
    }

    public static interface OrderRecivedDate {
    }

    public static interface OrderType {
    }

    public static interface Customer {
    }

    public static interface All extends Id, PoNumber, OrderQty, CustomerRequestedDate, TrwConfirmedDate, ActualDespatchDate, Comments, OrderRecivedDate, OrderType {

    }

    public static interface AllAndCustomerAll extends All, Customer, CustomerView.All {

    }

}
