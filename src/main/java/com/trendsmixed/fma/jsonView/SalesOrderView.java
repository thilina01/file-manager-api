package com.trendsmixed.fma.jsonView;

public class SalesOrderView {

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

    public static interface SaleType {
    }

    public static interface Customer {
    }

    public static interface SalesOrderItemList {
    }

    public static interface All extends Id, PoNumber, OrderQty, CustomerRequestedDate, TrwConfirmedDate, ActualDispatchedDate, Comments, OrderReceivedDate {
    }

    public static interface AllAndCustomerAll extends All, Customer, CustomerView.All {
    }

    public static interface AllAndCustomerAllAndSalesOrderTypeAll extends All, Customer, CustomerView.All, SaleType, SaleTypeView.All {
    }

    public static interface AllAndSalesOrderItemAll extends All, SalesOrderItemList, SalesOrderItemView.All {
    }
}
