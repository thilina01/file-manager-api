package com.trendsmixed.fma.module.loadingplanitem;

import com.trendsmixed.fma.module.customeritem.CustomerItemView.AllAndItemAll;
import com.trendsmixed.fma.module.dispatchnote.DispatchNoteView.AllAndInvoice;
import com.trendsmixed.fma.module.dispatchschedule.DispatchScheduleView;
import com.trendsmixed.fma.module.dispatchschedule.DispatchScheduleView.SalesOrderItem;
import com.trendsmixed.fma.module.invoice.InvoiceView.AllAndCustomer;
import com.trendsmixed.fma.module.invoice.InvoiceView.AllAndInvoiceType;
import com.trendsmixed.fma.module.item.ItemView.AllAndPaintAll;
import com.trendsmixed.fma.module.loadingplan.LoadingPlanView;
import com.trendsmixed.fma.module.loadingplan.LoadingPlanView.AllAndDispatchNote;
import com.trendsmixed.fma.module.packagingspecification.PackagingSpecificationView;
import com.trendsmixed.fma.module.salesorder.SalesOrderView.AllAndCustomerAll;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItemView.AllAndCustomerItem;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItemView.AllAndSalesOrder;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Thilina
 */
public class LoadingPlanItemView {

        public interface Id {
        }

        public interface CubicMeter {
        }

        public interface Quantity {
        }

        public interface RejectedQuantity {
        }

        public interface UnitPrice {
        }

        public interface PackagingSpecification {
        }

        public interface DispatchSchedule {
        }

        public interface LoadingPlan {
        }

        public interface All extends Id, CubicMeter, UnitPrice, Quantity, RejectedQuantity, PageView.All {
        }

        public interface AllAndPackagingSpecification
                        extends All, PackagingSpecification, PackagingSpecificationView.All {
        }

        public interface AllAndLoadingPlan extends All, LoadingPlan, LoadingPlanView.All {
        }

        public interface AllAndDispatchSchedule extends All, DispatchSchedule, DispatchScheduleView.All {
        }

        public interface AllAndLoadingPlanAndCustomerAndDispatchNote
                        extends All, LoadingPlan, LoadingPlanView.AllAndCustomerAndDispatchNote {
        }

        public interface AllAndPackagingSpecificationAndPalletSize
                        extends All, PackagingSpecification, PackagingSpecificationView.AllAndPalletSize {
        }

        public interface AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem
                        extends All, DispatchSchedule,
                        DispatchScheduleView.AllAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem {
        }

        public interface AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecification
                        extends All, DispatchSchedule,
                        DispatchScheduleView.AllAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem,
                        AllAndPackagingSpecification {
        }

        public interface AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPalletSize
                        extends All, DispatchSchedule,
                        DispatchScheduleView.AllAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem,
                        PackagingSpecification, PackagingSpecificationView.AllAndPalletSize {
        }

        public interface AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPalletSizeAndLoadingPlanAndCustomerAndDispatchNote
                        extends All, DispatchSchedule,
                        DispatchScheduleView.AllAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem,
                        PackagingSpecification, PackagingSpecificationView.AllAndPalletSize, LoadingPlan,
                        LoadingPlanView.AllAndCustomerAndDispatchNote {
        }

        public interface AllAndLoadingPlanAndDispatchNoteAndInvoice
                        extends All, AllAndLoadingPlan, AllAndDispatchNote, AllAndInvoice {
        }

        public interface AllAndLoadingPlanAndDispatchNoteAndInvoiceAndCustomerAndInvoiceType extends All,
                        AllAndLoadingPlan, AllAndDispatchNote, AllAndInvoice, AllAndInvoiceType, AllAndCustomer {
        }

        public interface AllAndSalesOrderItemAndCustomerItemAndSalesOrderAndCustomerAndItemAndPaint
                        extends All, SalesOrderItem, AllAndCustomerItem, AllAndSalesOrder, AllAndCustomerAll,
                        AllAndItemAll, AllAndPaintAll {
        }

        public interface AllAndDispatchScheduleAndLoadingPlanAndDispatchNoteAndinvoiceAndSalesOrderItemAndCustomerItemAndSalesOrderAndCustomerAndItemAndPaint
                        extends All, AllAndLoadingPlan, AllAndDispatchNote, AllAndInvoice, SalesOrderItem,
                        AllAndCustomerItem, AllAndSalesOrder, AllAndCustomerAll, AllAndItemAll, AllAndPaintAll,
                        DispatchSchedule, DispatchScheduleView.All {
        }

        public interface AllAndLoadingPlanAndDispatchNoteAndInvoiceAndCustomerAndInvoiceTypeAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem
                        extends All, AllAndLoadingPlan, AllAndDispatchNote, AllAndInvoice, AllAndInvoiceType,
                        AllAndCustomer, DispatchSchedule,
                        DispatchScheduleView.AllAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem {
        }

        public interface AllAndLoadingPlanAndDispatchNote extends All, AllAndLoadingPlan, AllAndDispatchNote {
        }

}
