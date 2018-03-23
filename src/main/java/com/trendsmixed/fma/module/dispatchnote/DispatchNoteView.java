package com.trendsmixed.fma.module.dispatchnote;

import com.trendsmixed.fma.module.address.AddressView;
import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.module.dispatch.DispatchView;
import com.trendsmixed.fma.module.dispatch.DispatchView.AllAndDispatchScheduleAll;
import com.trendsmixed.fma.module.dispatchschedule.DispatchScheduleView;
import com.trendsmixed.fma.module.employee.EmployeeView;
import com.trendsmixed.fma.module.location.LocationView;
import com.trendsmixed.fma.utility.PageView;

public class DispatchNoteView {

    public interface Id {
    }

    public interface DispatchDate {
    }

    public interface DeliveryTerm {
    }

    public interface ContainerNumber {
    }

    public interface VehicleNumber {
    }

    public interface DispatchReleaseTime {
    }

    public interface Recipient {
    }

    public interface Customer {
    }

    public interface Location {
    }

    public interface Employee {
    }

    public interface Address {
    }

    public interface Dispatch {
    }

    public interface Quantity {
    }

    public interface PackingListDispatchNote {
    }

    public interface All extends Id, DispatchDate, Quantity, ContainerNumber, VehicleNumber, DispatchReleaseTime, Recipient, PageView.All {
    }

    public interface AllAndDispatchAll extends All, Dispatch, DispatchView.All {
    }

    public interface AllAndEmployee extends All, Employee, EmployeeView.All {
    }

    public interface AllAndLocation extends All, Location, LocationView.All {
    }

    public interface AllAndAddress extends All, Address, AddressView.All {
    }

    public interface AllAndCustomer extends All, Customer, CustomerView.All {
    }

    public interface AllAndAddressAndEmployeeAndCustomerAndLocation extends All, Address, AddressView.All, Employee, EmployeeView.All, Customer, CustomerView.All, AllAndLocation {
    }

    public interface AllAndAddressAndEmployeeAndCustomerAndLocationAndDispatchAllAndDispatchScheduleAll extends AllAndAddressAndEmployeeAndCustomerAndLocation, AllAndDispatchAll, AllAndDispatchScheduleAll {
    }

    public interface AllAndAddressAndEmployeeAndCustomerAndLocationAndDispatchAllAndDispatchScheduleAllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll extends AllAndAddressAndEmployeeAndCustomerAndLocationAndDispatchAllAndDispatchScheduleAll, DispatchScheduleView.AllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll {
    }

    public interface AllAndDispatchAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem extends All, Dispatch, DispatchView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem {
    }

    public interface AllAndCustomerAndAddressAndEmployeeAndDispatchAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndLocation extends
            AllAndCustomer, AllAndAddress, AllAndEmployee, AllAndLocation, AllAndDispatchAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem{}
}
