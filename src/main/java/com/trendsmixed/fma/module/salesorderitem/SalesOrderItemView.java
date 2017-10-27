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

    public interface CustomerItem extends CustomerItemView.All {
    }

    public interface DispatchSchedule extends DispatchScheduleView.All {
    }

    public interface SalesOrder extends SalesOrderView.All {
    }

    public interface All extends Id, Quantity, Scheduled, UnitPrice, Amount, PageView.All {
    }

    public interface AllAndCustomerItemAll extends All, CustomerItem {
    }

    public interface AllAndCustomerItemAllAndSalesOrderAll extends AllAndCustomerItemAll, SalesOrder {
    }

    public interface AllAndCustomerItemAllAndSalesOrderAllAndDispatchScheduleAll extends AllAndCustomerItemAllAndSalesOrderAll, DispatchSchedule {
    }

    public interface AllAndCustomerItemAllAndItemAllAndSalesOrderAllAndDispatchScheduleAll extends AllAndCustomerItemAllAndSalesOrderAll, DispatchSchedule, CustomerItemView.AllAndItemAll {
    }

    public interface AllAndCustomerItemAllAndItemAllAndDispatchScheduleAll extends AllAndCustomerItemAll, DispatchSchedule, CustomerItemView.AllAndItemAll {
    }

}
