package com.trendsmixed.fma.module.dispatchnote;

import com.trendsmixed.fma.module.address.AddressView;
import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.module.dispatch.DispatchView;
import com.trendsmixed.fma.module.dispatch.DispatchView.AllAndDispatchScheduleAll;
import com.trendsmixed.fma.module.dispatchschedule.DispatchScheduleView;
import com.trendsmixed.fma.module.employee.EmployeeView;
import com.trendsmixed.fma.utility.PageView;

public class DispatchNoteView {

    public static interface Id {
    }

    public static interface DispatchDate {
    }

    public static interface DeliveryTerm {
    }

    public static interface ContainerNumber {
    }

    public static interface VehicleNumber {
    }

    public static interface DispatchReleaseTime {
    }

    public static interface Recipient {
    }

    public static interface Customer {
    }

    public static interface Employee {
    }

    public static interface Address {
    }

    public static interface Dispatch {
    }

    public static interface Quantity {
    }

    public static interface All extends Id, DispatchDate, Quantity, ContainerNumber, VehicleNumber, DispatchReleaseTime, Recipient, PageView.All {
    }

    public static interface AllAndDispatchAll extends All, Dispatch, DispatchView.All {
    }

    public static interface AllAndEmployeeAll extends All, Employee, EmployeeView.All {
    }

    public static interface AllAndAddressAll extends All, Address, AddressView.All {
    }

    public static interface AllAndCustomerAll extends All, Customer, CustomerView.All {
    }

    public static interface AllAndAddressAllAndEmployeeAllAndCustomerAll extends All, Address, AddressView.All, Employee, EmployeeView.All, Customer, CustomerView.All {
    }

    public static interface AllAndAddressAllAndEmployeeAllAndCustomerAllAndDispatchAllAndDispatchScheduleAll extends AllAndAddressAllAndEmployeeAllAndCustomerAll, AllAndDispatchAll, AllAndDispatchScheduleAll {
    }

    public static interface AllAndAddressAllAndEmployeeAllAndCustomerAllAndDispatchAllAndDispatchScheduleAllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll extends AllAndAddressAllAndEmployeeAllAndCustomerAllAndDispatchAllAndDispatchScheduleAll, DispatchScheduleView.AllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll {
    }

}
