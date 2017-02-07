package com.trendsmixed.fma.module.salesorder;

import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItemView;
import com.trendsmixed.fma.module.salesordertype.SalesOrderTypeView;

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

    public static interface SalesOrderType {
    }

    public static interface Customer {
    }

    public static interface SalesOrderItemList {
    }

    public static interface All extends Id, PoNumber, OrderQty, CustomerRequestedDate, TrwConfirmedDate, ActualDispatchedDate, Comments, OrderReceivedDate {
    }

    public static interface AllAndCustomerAll extends All, Customer, CustomerView.All {
    }

    public static interface AllAndCustomerAllAndSalesOrderTypeAll extends All, Customer, CustomerView.All, SalesOrderType, SalesOrderTypeView.All {
    }

    public static interface AllAndSalesOrderItemAll extends All, SalesOrderItemList, SalesOrderItemView.All {
    }
}
