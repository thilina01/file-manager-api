package com.trendsmixed.fma.module.dispatchschedule;

import com.trendsmixed.fma.module.dispatch.DispatchView;
import com.trendsmixed.fma.module.item.ItemView;
import com.trendsmixed.fma.module.job.JobView;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItemView;
import com.trendsmixed.fma.utility.PageView;

public class DispatchScheduleView {

    public interface Id {
    }

    public interface DispatchDate {
    }

    public interface ConfirmDate {
    }

    public interface RequestDate {
    }

    public interface Quantity {
    }

    public interface Comment {
    }

    public interface All extends Id, DispatchDate, ConfirmDate, RequestDate, Quantity, Comment, PageView.All {
    }

    public static interface Job extends JobView.All {
    }

    public static interface SalesOrderItem extends SalesOrderItemView.All {
    }

    public static interface Dispatch extends DispatchView.All {
    }

    public static interface AllAndSalesOrderItemAllAndCustomerItemAll extends All, SalesOrderItem, SalesOrderItemView.AllAndCustomerItemAll {
    }

    public static interface AllAndJobAllAndItemAll extends All, Job, JobView.AllAndItemAll {
    }

    public static interface AllAndSalesOrderItemAllAndCustomerItemAllAndJobAllAndItemAll extends AllAndSalesOrderItemAllAndCustomerItemAll, AllAndJobAllAndItemAll {
    }

    public static interface AllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll extends AllAndSalesOrderItemAllAndCustomerItemAllAndJobAllAndItemAll, SalesOrderItemView.AllAndCustomerItemAllAndSalesOrderAll {
    }

    public static interface AllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAllAndPaintAll extends AllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll, ItemView.AllAndPaintAll {
    }

}
