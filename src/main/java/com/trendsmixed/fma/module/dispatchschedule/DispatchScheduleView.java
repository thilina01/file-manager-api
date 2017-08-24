package com.trendsmixed.fma.module.dispatchschedule;

import com.trendsmixed.fma.module.job.JobView;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItemView;
import com.trendsmixed.fma.utility.PageView;

public class DispatchScheduleView {

    public static interface Id {
    }

    public static interface DispatchDate {
    }

    public static interface ConfirmDate {
    }

    public static interface RequestDate {
    }

    public static interface Quantity {
    }

    public static interface Comment {
    }

    public static interface All extends Id, DispatchDate, ConfirmDate, RequestDate, Quantity, Comment, PageView.All {
    }

    public static interface Job extends JobView.All {
    }

    public static interface SalesOrderItem extends SalesOrderItemView.All {
    }

    public static interface AllAndSalesOrderItemAllAndCustomerItemAll extends All, SalesOrderItem, SalesOrderItemView.AllAndCustomerItemAll {
    }

    public static interface AllAndJobAllAndItemAll extends All, Job, JobView.AllAndItemAll {
    }

    public static interface AllAndSalesOrderItemAllAndCustomerItemAllAndJobAllAndItemAll extends AllAndSalesOrderItemAllAndCustomerItemAll, AllAndJobAllAndItemAll {
    }
}
