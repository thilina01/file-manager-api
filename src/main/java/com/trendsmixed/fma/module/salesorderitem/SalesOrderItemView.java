package com.trendsmixed.fma.module.salesorderitem;

import com.trendsmixed.fma.module.customeritem.CustomerItemView;
import com.trendsmixed.fma.module.customeritem.CustomerItemView.AllAndItemAll;
import com.trendsmixed.fma.module.dispatchschedule.DispatchScheduleView;
import com.trendsmixed.fma.module.dispatchschedule.DispatchScheduleView.AllAndLoadingPlanItem;
import com.trendsmixed.fma.module.item.ItemView.AllAndPaintAll;
import com.trendsmixed.fma.module.salesorder.SalesOrderView;
import com.trendsmixed.fma.module.salesorder.SalesOrderView.AllAndCustomerAll;
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

        public interface Remarks {
        }

        public interface Line {
        }

        public interface LineType {
        }

        public interface UnitOfMeasure {
        }

        public interface Value {
        }

        public interface RequestedShipDate {
        }

        public interface InitialProposedDate {
        }

        public interface CompletedDate {
        }

        public interface Warehouse {
        }

        public interface Item {
        }

        public interface DispatchSchedule extends DispatchScheduleView.All {
        }

        public interface SalesOrder {
        }

        public interface Job {
        }

        public interface All extends Id, Quantity, Scheduled, UnitPrice, Amount, Remarks, PageView.All {
        }

        public interface AllAndSalesOrder extends All, SalesOrder, SalesOrderView.All {
        }

        public interface AllAndCustomerItem extends All, CustomerItem, CustomerItemView.All {
        }

        public interface AllAndSalesOrderAndCustomerItem extends AllAndSalesOrder, AllAndCustomerItem {
        }

        public interface AllAndCustomerItemAllAndSalesOrderAllAndDispatchScheduleAll
                        extends AllAndSalesOrderAndCustomerItem, DispatchSchedule {
        }

        public interface AllAndCustomerItemAllAndItemAllAndSalesOrderAllAndDispatchScheduleAll
                        extends AllAndSalesOrderAndCustomerItem, DispatchSchedule, CustomerItemView.AllAndItemAll {
        }

        public interface AllAndCustomerItemAllAndItemAllAndDispatchScheduleAll
                        extends AllAndCustomerItem, DispatchSchedule, CustomerItemView.AllAndItemAll {
        }

        public interface AllAndSalesOrderItemAndCustomerItemAndSalesOrderAndCustomerAndItemAndPaint extends All,
                        AllAndCustomerItem, AllAndSalesOrder, AllAndCustomerAll, AllAndItemAll, AllAndPaintAll {
        }

        // public interface
        // AllAndLoadingPlanItemAndLoadingPlanAndDispatchNoteAndinvoiceAndDispatchSchedule
        // extends All, AllAndLoadingPlan, AllAndDispatchNote, AllAndInvoice,
        // AllAndLoadingPlanItem,AllAndDispatchSchedule {
        // }

        public interface AllAndDispatchSchedule extends All, DispatchSchedule, DispatchScheduleView.All {
        }

        public interface AllAndDispatchScheduleAndLoadingPlanItemAndLoadingPlanAndDispatchNoteAndinvoiceAndSalesOrderItemAndCustomerItemAndSalesOrderAndCustomerAndItemAndPaint
                        extends All, DispatchSchedule, AllAndLoadingPlanItem,
                        DispatchScheduleView.AllAndLoadingPlanItemAndLoadingPlanAndDispatchNoteAndinvoice,
                        AllAndCustomerItem, AllAndSalesOrder, AllAndCustomerAll, AllAndItemAll, AllAndPaintAll {
        }

}
