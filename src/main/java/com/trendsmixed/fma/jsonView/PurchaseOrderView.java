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

    public static interface ActualDispatchedDate {
    }

    public static interface Comments {
    }

    public static interface OrderReceivedDate {
    }

    public static interface PurchaseOrderType {
    }

    public static interface Customer {
    }

    public static interface All extends Id, PoNumber, OrderQty, CustomerRequestedDate, TrwConfirmedDate, ActualDispatchedDate, Comments, OrderReceivedDate {
    }

    public static interface AllAndCustomerAll extends All, Customer, CustomerView.All {
    }

    public static interface AllAndCustomerAllAndPurchaseOrderTypeAll extends All, Customer, CustomerView.All, PurchaseOrderType, PurchaseOrderTypeView.AlL {
    }

}
