package com.trendsmixed.fma.module.salesorder;

import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItemView;
import com.trendsmixed.fma.module.salesordertype.SalesOrderTypeView;
import com.trendsmixed.fma.utility.PageView;

public class SalesOrderView {

    public interface Id {
    }

    public interface CustomerPONumber {
    }

    public interface Quantity {
    }

    public interface Amount {
    }

    public interface CustomerRequestedDate {
    }

    public interface TrwConfirmedDate {
    }

    public interface ActualDispatchedDate {
    }

    public interface Comments {
    }

    public interface OrderReceivedDate {
    }

    public interface SalesOrderType extends SalesOrderTypeView.All {
    }

    public interface Customer extends CustomerView.All {
    }

    public interface OrderDate {
    }

    public interface SalesOrderItem extends SalesOrderItemView.All {
    }

    public interface SalesOrderNumber {
    }

    public interface All extends Id, CustomerPONumber, Quantity, Amount, CustomerRequestedDate, TrwConfirmedDate, ActualDispatchedDate, Comments, OrderReceivedDate, SalesOrderNumber, OrderDate, PageView.All {
    }

    public interface AllAndCustomerAll extends All, Customer {
    }

    public interface AllAndCustomerAllAndSalesOrderTypeAll extends AllAndCustomerAll, SalesOrderType {
    }

    public interface AllAndCustomerAllAndSalesOrderTypeAllAndSalesOrderItemAll extends AllAndCustomerAllAndSalesOrderTypeAll, SalesOrderItem {
    }

    public interface AllAndCustomerAllAndSalesOrderTypeAllAndSalesOrderItemAllAndCustomerItemAll extends AllAndCustomerAllAndSalesOrderTypeAllAndSalesOrderItemAll, SalesOrderItemView.AllAndCustomerItemAll {
    }

    public interface AllAndCustomerAllAndSalesOrderTypeAllAndSalesOrderItemAllAndCustomerItemAllAndItemAllAndDispatchScheduleAll extends AllAndCustomerAllAndSalesOrderTypeAllAndSalesOrderItemAllAndCustomerItemAll, SalesOrderItemView.AllAndCustomerItemAllAndItemAllAndDispatchScheduleAll {
    }

}
