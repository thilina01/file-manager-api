package com.trendsmixed.fma.module.salesorderitem;

import com.trendsmixed.fma.module.customeritem.CustomerItemView;
import com.trendsmixed.fma.module.dispatchschedule.DispatchScheduleView;
import com.trendsmixed.fma.module.salesorder.SalesOrderView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class SalesOrderItemView {

    public interface Id {
    }

    public interface Quantity {
    }

    public interface Scheduled {
    }

    public interface UnitPrice {
    }

    public interface Amount {
    }

    public interface CustomerItem {
    }

    public interface DispatchSchedule extends DispatchScheduleView.All {
    }

    public interface SalesOrder {
    }

    public interface All extends Id, Quantity, Scheduled, UnitPrice, Amount, PageView.All {
    }

    public interface AllAndSalesOrder extends All, SalesOrder, SalesOrderView.All {}

    public interface AllAndCustomerItem extends All, CustomerItem, CustomerItemView.All {}

    public interface AllAndSalesOrderAndCustomerItem extends AllAndSalesOrder, AllAndCustomerItem {}


    public interface AllAndCustomerItemAllAndSalesOrderAllAndDispatchScheduleAll extends AllAndSalesOrderAndCustomerItem, DispatchSchedule {
    }

    public interface AllAndCustomerItemAllAndItemAllAndSalesOrderAllAndDispatchScheduleAll extends AllAndSalesOrderAndCustomerItem, DispatchSchedule, CustomerItemView.AllAndItemAll {
    }

    public interface AllAndCustomerItemAllAndItemAllAndDispatchScheduleAll extends AllAndCustomerItem, DispatchSchedule, CustomerItemView.AllAndItemAll {
    }
}
