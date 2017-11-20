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

    public interface Job extends JobView.All {
    }

    public interface SalesOrderItem {
    }

    public interface Dispatch extends DispatchView.All {
    }

    public interface AllAndSalesOrderItemAndCustomerItem extends All, SalesOrderItem, SalesOrderItemView.AllAndCustomerItem {
    }

    public interface AllAndJobAndItem extends All, Job, JobView.AllAndItemAll {
    }

    public interface AllAndSalesOrderItem extends All, SalesOrderItem, SalesOrderItemView.All {
    }

    public interface AllAndSalesOrderItemAllAndCustomerItemAllAndJobAllAndItemAll extends AllAndSalesOrderItemAndCustomerItem, AllAndJobAndItem {
    }

    public interface AllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll extends AllAndSalesOrderItemAllAndCustomerItemAllAndJobAllAndItemAll, SalesOrderItemView.AllAndSalesOrderAndCustomerItem {
    }

    public interface AllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAllAndPaintAll extends AllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll, ItemView.AllAndPaintAll {
    }

    public interface AllAndSalesOrderItemAndSalesOrderAndCustomerItem extends All, SalesOrderItem, SalesOrderItemView.AllAndSalesOrderAndCustomerItem{
    }

    public interface AllAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem extends AllAndJobAndItem, AllAndSalesOrderItemAndSalesOrderAndCustomerItem{}
}
