package com.trendsmixed.fma.module.dispatchnote;

import com.trendsmixed.fma.module.address.AddressView;
import com.trendsmixed.fma.module.invoice.InvoiceView;
import com.trendsmixed.fma.module.address.AddressView.AllAndAddressTypeAll;
import com.trendsmixed.fma.module.address.AddressView.AllAndCountryAll;
import com.trendsmixed.fma.module.address.AddressView.AllAndPortAll;
import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.module.customer.CustomerView.AllAndContactAll;
import com.trendsmixed.fma.module.customer.CustomerView.AllAndCurrencyAll;
import com.trendsmixed.fma.module.customer.CustomerView.AllAndEmployeeAll;
import com.trendsmixed.fma.module.customer.CustomerView.AllAndIncotermAll;
import com.trendsmixed.fma.module.customer.CustomerView.AllAndNotifyPartyAll;
import com.trendsmixed.fma.module.customer.CustomerView.AllAndPaymentTermAll;
// import com.trendsmixed.fma.module.dispatch.DispatchView;
// import com.trendsmixed.fma.module.dispatch.DispatchView.AllAndDispatchScheduleAll;
// import com.trendsmixed.fma.module.dispatchschedule.DispatchScheduleView;
import com.trendsmixed.fma.module.loadingplan.LoadingPlanView;
import com.trendsmixed.fma.module.loadingplan.LoadingPlanView.AllAndAddress;
import com.trendsmixed.fma.module.loadingplan.LoadingPlanView.AllAndContainerSize;
import com.trendsmixed.fma.module.loadingplan.LoadingPlanView.AllAndPortOfLoading;
import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItemView.AllAndPackagingSpecification;
import com.trendsmixed.fma.module.employee.EmployeeView;
import com.trendsmixed.fma.module.location.LocationView;
import com.trendsmixed.fma.module.packagingspecification.PackagingSpecificationView.AllAndPalletSize;
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

        public interface Invoice {
        }

        public interface LoadingPlan {
        }

        public interface All extends Id, DispatchDate, ContainerNumber, VehicleNumber, DispatchReleaseTime, Recipient,
                        PageView.All {
        }

        public interface AllAndEmployee extends All, Employee, EmployeeView.All {
        }

        public interface AllAndInvoice extends All, Invoice, InvoiceView.All {
        }

        public interface AllAndLocation extends All, Location, LocationView.All {
        }

        public interface AllAndCustomer extends All, Customer, CustomerView.All {
        }

        public interface AllAndLoadingPlan extends All, LoadingPlan, LoadingPlanView.All {
        }

        public interface AllAndCustomerAndLocation extends All, AllAndCustomer, AllAndLocation {
        }

        // public interface AllAndAddressAndEmployeeAndCustomerAndLocationAndDispatchAllAndDispatchScheduleAll
        //         extends AllAndAddressAndEmployeeAndCustomerAndLocation, AllAndDispatchAll, AllAndDispatchScheduleAll {
        // }

        // public interface AllAndAddressAndEmployeeAndCustomerAndLocationAndDispatchAllAndDispatchScheduleAllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll
        //         extends AllAndAddressAndEmployeeAndCustomerAndLocationAndDispatchAllAndDispatchScheduleAll,
        //         DispatchScheduleView.AllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll {
        // }

        // public interface AllAndDispatchAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem
        //         extends All, Dispatch,
        //         DispatchView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem {
        // }

        // public interface AllAndCustomerAndAddressAndEmployeeAndDispatchAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndLocation
        //         extends AllAndCustomer, AllAndAddress, AllAndEmployee, AllAndLocation,
        //         AllAndDispatchAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem {
        // }

        public interface AllAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddress
                        extends All, LoadingPlan,
                        LoadingPlanView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem,
                        AllAndPackagingSpecification, AllAndPortOfLoading, AllAndContainerSize, AllAndAddress {
        }

        public interface AllAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCustomer
                        extends All, LoadingPlan,
                        LoadingPlanView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem,
                        AllAndPackagingSpecification, AllAndPortOfLoading, AllAndContainerSize, AllAndCustomer,
                        AllAndAddress {
        }

        public interface AllAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCountryAndPortAndCustomer
                        extends All, LoadingPlan,
                        LoadingPlanView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem,
                        AllAndPackagingSpecification, AllAndPalletSize, AllAndPortOfLoading, AllAndContainerSize,
                        AllAndCustomer, AllAndAddress, AddressView.AllAndAddressTypeAndCountryAndPort, AllAndCountryAll,
                        AllAndPortAll, AllAndAddressTypeAll, AllAndIncotermAll, AllAndNotifyPartyAll, AllAndCurrencyAll,
                        AllAndPaymentTermAll, AllAndEmployeeAll, AllAndContactAll {

        }

        public interface AllAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCountryAndPortAndCustomerAndLocation
                        extends All, LoadingPlan,
                        LoadingPlanView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem,
                        AllAndPackagingSpecification, AllAndPalletSize, AllAndPortOfLoading, AllAndContainerSize,
                        AllAndCustomer, AllAndAddress, AddressView.AllAndAddressTypeAndCountryAndPort, AllAndCountryAll,
                        AllAndPortAll, AllAndAddressTypeAll, AllAndIncotermAll, AllAndNotifyPartyAll, AllAndCurrencyAll,
                        AllAndPaymentTermAll, AllAndEmployeeAll, AllAndContactAll, AllAndLocation {

        }

}
