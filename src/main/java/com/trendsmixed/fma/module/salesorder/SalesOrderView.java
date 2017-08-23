package com.trendsmixed.fma.module.salesorder;

import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItemView;
import com.trendsmixed.fma.module.salesordertype.SalesOrderTypeView;
import com.trendsmixed.fma.utility.PageView;

public class SalesOrderView {

    public static interface Id {
    }

    public static interface CustomerPONumber {
    }

    public static interface Quantity {
    }

    public static interface Amount {
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

    public static interface SalesOrderType extends SalesOrderTypeView.All {
    }

    public static interface Customer extends CustomerView.All {
    }

    public static interface OrderDate {
    }

    public static interface SalesOrderItem extends SalesOrderItemView.All {
    }

    public static interface SalesOrderNumber {
    }

    public static interface All extends Id, CustomerPONumber, Quantity, Amount, CustomerRequestedDate, TrwConfirmedDate, ActualDispatchedDate, Comments, OrderReceivedDate, SalesOrderNumber, OrderDate, PageView.All {
    }

    public static interface AllAndCustomerAll extends All, Customer {
    }

    public static interface AllAndCustomerAllAndSalesOrderTypeAll extends AllAndCustomerAll, SalesOrderType {
    }

    public static interface AllAndCustomerAllAndSalesOrderTypeAllAndSalesOrderItemAll extends AllAndCustomerAllAndSalesOrderTypeAll, SalesOrderItem {
    }

    public static interface AllAndCustomerAllAndSalesOrderTypeAllAndSalesOrderItemAllAndCustomerItemAll extends AllAndCustomerAllAndSalesOrderTypeAllAndSalesOrderItemAll, SalesOrderItemView.AllAndCustomerItemAll {
    }

    public static interface AllAndCustomerAllAndSalesOrderTypeAllAndSalesOrderItemAllAndCustomerItemAllAndItemAllAndJobAll extends AllAndCustomerAllAndSalesOrderTypeAllAndSalesOrderItemAllAndCustomerItemAll, SalesOrderItemView.AllAndCustomerItemAllAndItemAllAndJobAll {
    }

}
