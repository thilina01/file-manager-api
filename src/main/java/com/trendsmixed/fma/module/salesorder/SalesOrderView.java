package com.trendsmixed.fma.module.salesorder;

import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.module.customeritem.CustomerItemView.AllAndItemAll;
import com.trendsmixed.fma.module.dispatchnote.DispatchNoteView.AllAndInvoice;
import com.trendsmixed.fma.module.dispatchschedule.DispatchScheduleView.AllAndLoadingPlanItem;
import com.trendsmixed.fma.module.item.ItemView.AllAndPaintAll;
import com.trendsmixed.fma.module.loadingplan.LoadingPlanView.AllAndDispatchNote;
import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItemView.AllAndLoadingPlan;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItemView;
import com.trendsmixed.fma.module.salesordertype.SalesOrderTypeView;
import com.trendsmixed.fma.utility.PageView;

public class SalesOrderView {

    public interface Id {
    }

    public interface CustomerPONumber {
    }

    public interface Quantity {
    }

    public interface Amount {
    }

    public interface CustomerRequestedDate {
    }

    public interface TrwConfirmedDate {
    }

    public interface ActualDispatchedDate {
    }

    public interface Comments {
    }

    public interface OrderReceivedDate {
    }

    public interface SalesOrderType extends SalesOrderTypeView.All {
    }

    public interface Customer extends CustomerView.All {
    }

    public interface OrderDate {
    }

    public interface SalesOrderItem {
    }

    public interface SalesOrderNumber {
    }

    public interface Display {
    }

    public interface All extends Id, CustomerPONumber, Quantity, Amount, CustomerRequestedDate, TrwConfirmedDate, ActualDispatchedDate, Comments, OrderReceivedDate, SalesOrderNumber, OrderDate, PageView.All {
    }

    public interface AllAndCustomerAll extends All, Customer {
    }

    public interface AllAndSalesOrderItem extends All, SalesOrderItem, SalesOrderItemView.All {
    }

    public interface AllAndCustomerAllAndSalesOrderTypeAll extends AllAndCustomerAll, SalesOrderType {
    }

    public interface AllAndCustomerAllAndSalesOrderTypeAllAndSalesOrderItemAll extends AllAndCustomerAllAndSalesOrderTypeAll, AllAndSalesOrderItem  {
    }

    public interface AllAndCustomerAllAndSalesOrderTypeAllAndSalesOrderItemAllAndCustomerItemAll extends AllAndCustomerAllAndSalesOrderTypeAllAndSalesOrderItemAll, SalesOrderItemView.AllAndCustomerItem {
    }

    public interface AllAndCustomerAllAndSalesOrderTypeAllAndSalesOrderItemAllAndCustomerItemAllAndItemAllAndDispatchScheduleAll extends AllAndCustomerAllAndSalesOrderTypeAllAndSalesOrderItemAllAndCustomerItemAll, SalesOrderItemView.AllAndCustomerItemAllAndItemAllAndDispatchScheduleAll {
    }

    public interface AllAndDispatchScheduleAndLoadingPlanItemAndLoadingPlanAndDispatchNoteAndinvoice extends All, AllAndLoadingPlanItem, AllAndItemAll, AllAndPaintAll,AllAndInvoice,AllAndLoadingPlan,AllAndDispatchNote {
    }

    public interface AllAndCustomerAllAndSalesOrderTypeAllAndSalesOrderItemAllAndCustomerItemAllAndItemAllAndDispatchScheduleAndLoadingPlanItemAndLoadingPlanAndDispatchNoteAndinvoice extends AllAndCustomerAllAndSalesOrderTypeAllAndSalesOrderItemAllAndCustomerItemAll, SalesOrderItemView.AllAndCustomerItemAllAndItemAllAndDispatchScheduleAll,AllAndLoadingPlanItem,AllAndInvoice,AllAndDispatchNote,AllAndLoadingPlan {
    }


}
