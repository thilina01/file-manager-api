package com.trendsmixed.fma.module.loadingplan;

import com.trendsmixed.fma.module.address.AddressView;
import com.trendsmixed.fma.module.address.AddressView.AllAndAddressTypeAll;
import com.trendsmixed.fma.module.address.AddressView.AllAndCountryAll;
import com.trendsmixed.fma.module.address.AddressView.AllAndPortAll;
import com.trendsmixed.fma.module.containersize.ContainerSizeView;
import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.module.customer.CustomerView.*;
import com.trendsmixed.fma.module.dispatchnote.DispatchNoteView;
import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItemView;
import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItemView.AllAndPackagingSpecification;
import com.trendsmixed.fma.module.packagingspecification.PackagingSpecificationView.AllAndPalletSize;
import com.trendsmixed.fma.module.port.PortView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Thilina
 */
public class LoadingPlanView {

        public interface Id {
        }

        public static interface NoOfContainers {
        }

        public static interface LoadingPlanDate {
        }

        public static interface Port {
        }

        public interface Customer {
        }

        public interface Employee {
        }

        public interface DispatchNote {
        }

        public static interface Address {
        }

        public static interface Invoice {
        }

        public static interface ContainerSize {
        }

        public static interface LoadingPlanItem {
        }

        public static interface PortOfLoading {
        }

        public interface All extends Id, NoOfContainers, LoadingPlanDate, PageView.All {
        }

        public interface AllAndAddress extends All, Address, AddressView.All {
        }

        public interface AllAndDispatchNote extends All, DispatchNote, DispatchNoteView.All {
        }

        public interface AllAndCustomer extends All, Customer, CustomerView.All {
        }

        public static interface AllAndPortOfLoading extends All, PortOfLoading, PortView.All {
        }

        public static interface AllAndContainerSize extends All, ContainerSize, ContainerSizeView.All {
        }

        public interface AllAndAddressAndCustomer extends AllAndCustomer, AllAndAddress {
        }

        public interface AllAndCustomerAndDispatchNote extends AllAndCustomer, AllAndDispatchNote {
        }

        public static interface AllAndPortOfLoadingAndContainerSize extends AllAndPortOfLoading, AllAndContainerSize {
        }

        public static interface AllAndPortOfLoadingAndContainerSizeAndAddressAndCustomer
                        extends AllAndPortOfLoading, AllAndContainerSize, AllAndCustomer, AllAndAddress {
        }

        public interface AllAndLoadingPlanItem extends All, LoadingPlanItem, LoadingPlanItemView.All {
        }

        public interface AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem
                        extends All, LoadingPlanItem,
                        LoadingPlanItemView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem {
        }

        public interface AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPortOfLoadingAndContainerSizeAndAddressAndCustomer
                        extends All, LoadingPlanItem,
                        LoadingPlanItemView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem,
                        AllAndPortOfLoading, AllAndContainerSize, AllAndCustomer, AllAndAddress {
        }

        public interface AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCustomer
                        extends All, LoadingPlanItem,
                        LoadingPlanItemView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem,
                        AllAndPackagingSpecification, AllAndPortOfLoading, AllAndContainerSize, AllAndCustomer,
                        AllAndAddress {
        }

        public interface AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCountryAndPortAndCustomer
                        extends All, LoadingPlanItem,
                        LoadingPlanItemView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem,
                        AllAndPackagingSpecification, AllAndPalletSize, AllAndPortOfLoading, AllAndContainerSize,
                        AllAndCustomer, AllAndAddress, AddressView.AllAndAddressTypeAndCountryAndPort, AllAndCountryAll,
                        AllAndPortAll, AllAndAddressTypeAll, AllAndIncotermAll, AllAndNotifyPartyAll, AllAndCurrencyAll,
                        AllAndPaymentTermAll, AllAndEmployeeAll, AllAndContactAll {

        }

        public interface AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPalletSizeAndPortOfLoadingAndContainerSizeAndAddressAndCountryAndPortAndCustomer
                        extends All, LoadingPlanItem,
                        LoadingPlanItemView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem,
                        AllAndPackagingSpecification, AllAndPalletSize, AllAndPortOfLoading, AllAndContainerSize,
                        AllAndCustomer, AllAndAddress, AddressView.AllAndAddressTypeAndCountryAndPort, AllAndCountryAll,
                        AllAndPortAll, AllAndAddressTypeAll, AllAndIncotermAll, AllAndNotifyPartyAll, AllAndCurrencyAll,
                        AllAndPaymentTermAll, AllAndEmployeeAll, AllAndContactAll {

        }

        public interface AllAndLoadingPlanItemAndDispatchNoteAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCountryAndPortAndCustomer
                        extends
                        AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCountryAndPortAndCustomer,
                        AllAndDispatchNote {

        }

}