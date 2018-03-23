package com.trendsmixed.fma.module.loadingplan;

import com.trendsmixed.fma.utility.PageView;
import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItemView;
import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItemView.AllAndPackagingSpecification;
import com.trendsmixed.fma.module.containersize.ContainerSizeView;
import com.trendsmixed.fma.module.port.PortView;
import com.trendsmixed.fma.module.address.AddressView;

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

        public static interface Address {
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

        public interface AllAndCustomer extends All, Customer, CustomerView.All {
        }

        public static interface AllAndPortOfLoading extends All, PortOfLoading, PortView.All {
        }

        public static interface AllAndContainerSize extends All, ContainerSize, ContainerSizeView.All {
        }

        public interface AllAndAddressAndCustomer extends AllAndCustomer, AllAndAddress {
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

}