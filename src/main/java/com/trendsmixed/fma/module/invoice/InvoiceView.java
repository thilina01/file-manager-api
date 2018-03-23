package com.trendsmixed.fma.module.invoice;

import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.module.invoicetype.InvoiceTypeView;

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

        public interface PackingList {
        }

        public interface InvoiceDispatchNote {
        }

        public interface All extends Id, InvoiceNumber, InvoiceDate, PageView.All {
        }

        public interface AllAndInvoiceTypeAll extends All, InvoiceType, InvoiceTypeView.All {
        }

        public interface AllAndCustomerAll extends All, Customer, CustomerView.All {
        }

        public interface AllAndCustomerAllAndInvoiceTypeAll extends AllAndCustomerAll, AllAndInvoiceTypeAll {
        }

        // public interface AllAndInvoiceDispatchNoteAndDispatchNoteAndDispatchAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem
        //                 extends All, InvoiceDispatchNote,
        //                 InvoiceDispatchNoteView.AllAndDispatchNoteAndDispatchAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem {
        // }

        // public interface AllAndCustomerAndInvoiceTypeAndInvoiceDispatchNoteAndDispatchNoteAndDispatchAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem
        //                 extends AllAndCustomerAllAndInvoiceTypeAll,
        //                 AllAndInvoiceDispatchNoteAndDispatchNoteAndDispatchAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem {
        // }

}
