package com.trendsmixed.fma.module.dispatchschedule;

import com.trendsmixed.fma.module.dispatch.DispatchView;
import com.trendsmixed.fma.module.dispatchnote.DispatchNoteView.AllAndInvoice;
import com.trendsmixed.fma.module.item.ItemView;
import com.trendsmixed.fma.module.item.ItemView.AllAndPaintAll;
import com.trendsmixed.fma.module.job.JobView;
import com.trendsmixed.fma.module.loadingplan.LoadingPlanView.AllAndDispatchNote;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItemView;
import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItemView;
import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItemView.AllAndLoadingPlan;
import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItemView.AllAndLoadingPlanAndDispatchNoteAndinvoice;
import com.trendsmixed.fma.module.salesorder.SalesOrderView;
import com.trendsmixed.fma.module.salesorder.SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll;
import com.trendsmixed.fma.module.salesorder.SalesOrderView.Customer;
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

        public interface LoadingPlanItem {
        }

        public interface Dispatch extends DispatchView.All {
        }

        public interface AllAndSalesOrderItemAndCustomerItem
                        extends All, SalesOrderItem, SalesOrderItemView.AllAndCustomerItem {
        }

        public interface AllAndJobAndItem extends All, Job, JobView.AllAndItemAll {
        }

        public interface AllAndSalesOrderItem extends All, SalesOrderItem, SalesOrderItemView.All {
        }

        public interface AllAndLoadingPlanItem extends All, LoadingPlanItem, LoadingPlanItemView.All {
        }

        public interface AllAndCustomer extends All, Customer, SalesOrderView.All {
        }

        public interface AllAndSalesOrderItemAllAndCustomerItemAllAndJobAllAndItemAll
                        extends AllAndSalesOrderItemAndCustomerItem, AllAndJobAndItem {
        }

        public interface AllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll
                        extends AllAndSalesOrderItemAllAndCustomerItemAllAndJobAllAndItemAll,
                        SalesOrderItemView.AllAndSalesOrderAndCustomerItem {
        }

        public interface AllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAllAndPaintAll
                        extends AllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll,
                        ItemView.AllAndPaintAll {
        }

        public interface AllAndSalesOrderItemAndSalesOrderAndCustomerItem
                        extends All, SalesOrderItem, SalesOrderItemView.AllAndSalesOrderAndCustomerItem {
        }

        public interface AllAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem
                        extends AllAndJobAndItem, AllAndSalesOrderItemAndSalesOrderAndCustomerItem {
        }

        public interface AllAndSalesOrderItemAllAndSalesOrderAllCustomerAllCustomerItemAllAndJobAllAndItemAll
                        extends AllAndSalesOrderItemAllAndCustomerItemAllAndJobAllAndItemAll,
                        SalesOrderItemView.AllAndSalesOrderAndCustomerItem, AllAndCustomer, SalesOrderView.All {
        }

        public interface AllAndSalesOrderItemAllAndSalesOrderAllAndSalesOrderTypeAllAndCustomerAllCustomerItemAllAndJobAllAndPaintAllAndItemAllAndLoadingPlanItemAllAndLoadingPlanAll
                        extends AllAndSalesOrderItemAllAndCustomerItemAllAndJobAllAndItemAll, AllAndPaintAll,
                        AllAndCustomerAllAndSalesOrderTypeAll, SalesOrderItemView.AllAndSalesOrderAndCustomerItem,
                        AllAndCustomer, SalesOrderView.All, AllAndLoadingPlanItem ,AllAndLoadingPlan{
        }


        public interface AllAndLoadingPlanItemAndLoadingPlanAndDispatchNoteAndinvoice extends  LoadingPlanItem, AllAndLoadingPlanAndDispatchNoteAndinvoice,AllAndLoadingPlan, AllAndDispatchNote, AllAndInvoice{
        }

}
