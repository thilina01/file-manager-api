package com.trendsmixed.fma.module.invoice;

import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.module.customeritem.CustomerItemView.Item;
import com.trendsmixed.fma.module.dispatch.DispatchView;
import com.trendsmixed.fma.module.dispatch.DispatchView.AllAndDispatchScheduleAll;
import com.trendsmixed.fma.module.dispatch.DispatchView.DispatchSchedule;
import com.trendsmixed.fma.module.dispatchnote.DispatchNoteView;
import com.trendsmixed.fma.module.dispatchschedule.DispatchScheduleView;
import com.trendsmixed.fma.module.dispatchschedule.DispatchScheduleView.Job;
import com.trendsmixed.fma.module.dispatchschedule.DispatchScheduleView.SalesOrderItem;
import com.trendsmixed.fma.module.invoicedispatchnote.InvoiceDispatchNoteView;
import com.trendsmixed.fma.module.invoicetype.InvoiceTypeView;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItemView.CustomerItem;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItemView.SalesOrder;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class InvoiceView {

    public interface Id {
    }

    public interface InvoiceType {
    }

    public interface InvoiceDate {
    }

    public interface InvoiceNumber {
    }

    public interface Customer {
    }

    public interface InvoiceDispatchNote {
    }

    public interface Dispatch {

    }

    public interface dispatchSchedule {

    }

    public interface DispatchList {
    }

    public interface NetWeight {
    }

    public interface GrossWeight {
    }

    public interface Cbm {
    }

    public interface Pkgs {
    }

    public interface All extends Id, InvoiceNumber, InvoiceDate, NetWeight, GrossWeight, Cbm, Pkgs, PageView.All {
    }

    public interface AllAndInvoiceDispatchNoteAllAndDispatchNoteAllAndDispatchAll extends All, InvoiceDispatchNote, InvoiceDispatchNoteView.AllAndDispatchNoteAllAndDispatchAll{
    }

    public interface AllAndInvoiceTypeAll extends All, InvoiceType, InvoiceTypeView.All {
    }

    public interface AllAndCustomerAll extends All, Customer, CustomerView.All {
    }

    public interface AllAndItemAll extends All, Item, DispatchScheduleView.All {
    }

    public interface AllAndDispatchList extends All, DispatchList, DispatchNoteView.All {
    }

    public interface AllAndDispatchSchedule extends All, DispatchSchedule, DispatchScheduleView.All {
    }

    public interface AllAndDispatchAll extends All, Dispatch, DispatchView.All {
    }

    public interface AllAndDispatchListAllAndDispatchScheduleAllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAllAndDispatchAll extends All, DispatchList, DispatchSchedule, SalesOrderItem, SalesOrder, CustomerItem, Job, DispatchNoteView.AllAndDispatchAll {
    }

    public interface AllAndInvoiceTypeAllAndCustomerAllAndDispatchList extends All, InvoiceType, InvoiceTypeView.All, Customer, CustomerView.All, AllAndDispatchList {
    }

    public interface AllAndInvoiceTypeAllAndCustomerAll extends All, InvoiceType, InvoiceTypeView.All, Customer, CustomerView.All {
    }

    public interface AllAndInvoiceTypeAllAndCustomerAndAllAndDispatchAllAndDispatchScheduleAll extends AllAndInvoiceTypeAllAndCustomerAll, AllAndDispatchAll, AllAndDispatchScheduleAll {
    }

    public interface AllAndInvoiceTypeAllAndCustomerAllAndDispatchNoteAndDispatchListAndDispatchAllAndDispatchScheduleAllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll extends All, InvoiceType, InvoiceTypeView.All, Customer, CustomerView.All, DispatchScheduleView.AllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll, AllAndDispatchListAllAndDispatchScheduleAllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAllAndDispatchAll, AllAndInvoiceDispatchNoteAllAndDispatchNoteAllAndDispatchAll {
    }
}
