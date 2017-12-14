package com.trendsmixed.fma.module.packinglist;

import com.trendsmixed.fma.module.containersize.ContainerSizeView;
import com.trendsmixed.fma.module.country.CountryView;
import com.trendsmixed.fma.module.employee.EmployeeView;
import com.trendsmixed.fma.module.invoice.InvoiceView;
import com.trendsmixed.fma.module.port.PortView;
import com.trendsmixed.fma.utility.PageView;

public class PackingListView {

    public static interface Id {
    }

    public static interface NoOfContainers {
    }

    public static interface NetWeight {
    }

    public static interface GrossWeight {
    }

    public static interface Cbm {
    }

    public static interface NumberOfPackage {
    }

    public static interface Port {
    }

    public static interface Country {
    }

    public static interface ContainerSize {
    }

    public static interface PortOfLoading {
    }

    public static interface Invoice {
    }

    public interface Employee {
    }

    public static interface All extends Id, NoOfContainers, NetWeight, GrossWeight, Cbm, NumberOfPackage, PageView.All {
    }

    public static interface AllAndPortAll extends All, Port, PortView.All {
    }

    public static interface AllAndPortOfLoadingAll extends All, PortOfLoading, PortView.All {
    }

    public interface AllAndEmployeeAll extends All, Employee, EmployeeView.All {
    }

    public static interface AllAndCountryAll extends All, Country, CountryView.All {
    }

    public static interface AllAndContainerSizeAll extends All, ContainerSize, ContainerSizeView.All {
    }

    public static interface AllAndInvoiceAll extends All, Invoice, InvoiceView.All {
    }

    public static interface AllAndPortOfLoadingAndPortAllAndCountryAllAndAndEmployeeAllAndContainerSizeAllAndInvoiceAll extends All, Port, PortOfLoading, PortView.All, Country, CountryView.All, AllAndEmployeeAll, ContainerSize, ContainerSizeView.All, Invoice, InvoiceView.All {
    }

    public interface AllAndCustomerAndInvoiceTypeAndInvoiceDispatchNoteAndDispatchNoteAndDispatchAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem extends InvoiceView.AllAndCustomerAllAndInvoiceTypeAll, InvoiceView.AllAndInvoiceDispatchNoteAndDispatchNoteAndDispatchAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem {
    }

}
