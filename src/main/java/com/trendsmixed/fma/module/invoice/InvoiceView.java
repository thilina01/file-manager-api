package com.trendsmixed.fma.module.invoice;

import com.trendsmixed.fma.module.address.AddressView;
import com.trendsmixed.fma.module.address.AddressView.AllAndAddressTypeAll;
import com.trendsmixed.fma.module.address.AddressView.AllAndCountryAll;
import com.trendsmixed.fma.module.address.AddressView.AllAndPortAll;
import com.trendsmixed.fma.module.currency.CurrencyView;
import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.module.customer.CustomerView.*;
import com.trendsmixed.fma.module.dispatchnote.DispatchNoteView;
import com.trendsmixed.fma.module.dispatchnote.DispatchNoteView.AllAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddress;
import com.trendsmixed.fma.module.exchangerate.ExchangeRateView;
import com.trendsmixed.fma.module.exchangerate.ExchangeRateView.AllAndCurrencyId;
import com.trendsmixed.fma.module.invoicetype.InvoiceTypeView;
import com.trendsmixed.fma.module.loadingplan.LoadingPlanView;
import com.trendsmixed.fma.module.loadingplan.LoadingPlanView.AllAndAddress;
import com.trendsmixed.fma.module.loadingplan.LoadingPlanView.AllAndContainerSize;
import com.trendsmixed.fma.module.loadingplan.LoadingPlanView.AllAndPortOfLoading;
import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItemView.AllAndPackagingSpecification;
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

        public interface TotalAmount {
        }

        public interface TotalWeight {
        }

        public interface InvoiceDate {
        }

        public interface InvoiceNumber {
        }

        public interface TaxRate {
        }

        public interface Customer {
        }

        public interface TaxValue {
        }

        public interface TotalSalesAmount {
        }

        public interface DispatchNote {
        }

        public interface ExchangeRate {
        }

        public interface Currency {
        }

        public interface Employee {
        }

        public interface LoadingPlan {
        }

        public interface All extends Id, InvoiceNumber, InvoiceDate, TaxRate, TotalAmount, TotalWeight,
                        TotalSalesAmount, TaxValue, PageView.All {
        }

        public interface AllAndInvoiceType extends All, InvoiceType, InvoiceTypeView.All {
        }

        public interface AllAndExchangeRate extends All, ExchangeRate, ExchangeRateView.All {
        }

        public interface AllAndCustomer extends All, Customer, CustomerView.All {
        }

        public interface AllAndCurrency extends All, Currency, CurrencyView.All {
        }

        public interface AllAndExchangeRateAndCurrency extends All, AllAndCurrency, ExchangeRateView.All {
        }

        public interface AllAndDispatchNote extends All, DispatchNote, DispatchNoteView.All {
        }

        public interface AllAndLoadingPlan extends All, LoadingPlan, LoadingPlanView.All {
        }

        public interface AllAndCustomerAndInvoiceType extends All, AllAndInvoiceType, AllAndCustomer {
        }

        public interface AllAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCustomerAndInvoiceType
                        extends All, LoadingPlan,
                        LoadingPlanView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem,
                        AllAndPackagingSpecification, AllAndPortOfLoading, AllAndContainerSize, AllAndCustomer,
                        AllAndInvoiceType, AllAndAddress {
        }

        public interface AllAndCustomerAndIncotermAndCurrencyAndNotifyPartyAndPaymentTermAndEmployee extends All,
                        Customer, CustomerView.AllAndIncotermAndCurrencyAndNotifyPartyAndPaymentTermAndEmployee,
                        AllAndIncotermAll, AllAndEmployeeAll, AllAndPaymentTermAll, AllAndNotifyPartyAll,
                        AllAndCurrencyAll {
        }

        public interface AllAndAddressAndAddressTypeAndCountryAndPort
                        extends All, AddressView.AllAndAddressTypeAndCountryAndPort, AllAndCountryAll, AllAndPortAll,
                        AllAndAddressTypeAll {
        }

        public interface AllAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCountryAndPortAndCustomerAndIncotermAndInvoiceType
                        extends All, LoadingPlan,
                        LoadingPlanView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem,
                        AllAndPackagingSpecification, AllAndPortOfLoading, AllAndContainerSize, AllAndCustomer,
                        AllAndInvoiceType, AllAndAddress, AddressView.AllAndAddressTypeAndCountryAndPort,
                        AllAndCountryAll, AllAndPortAll, AllAndAddressTypeAll, AllAndIncotermAll, AllAndNotifyPartyAll,
                        AllAndCurrencyAll, AllAndPaymentTermAll, AllAndEmployeeAll, AllAndContactAll {
        }

        public interface AllAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCustomerAndIncotermAndInvoiceTypeAndExchangeRate
                        extends All, LoadingPlan,
                        LoadingPlanView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem,
                        AllAndPackagingSpecification, AllAndPortOfLoading, AllAndContainerSize, AllAndCustomer,
                        AllAndCountryAll, AllAndCurrencyAll, AllAndPortAll, AllAndIncotermAll, AllAndNotifyPartyAll,
                        AllAndPaymentTermAll, AllAndEmployeeAll, AllAndContactAll, AllAndInvoiceType,
                        AllAndExchangeRate, AllAndAddress, AddressView.AllAndAddressTypeAndCountryAndPort {
        }

        public interface AllAndDispatchNoteAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCustomerAndIncotermAndInvoiceType
                        extends All, DispatchNote,
                        AllAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddress,
                        AllAndPackagingSpecification, AllAndPortOfLoading, AllAndInvoiceType, AllAndExchangeRate,
                        AllAndContainerSize, AllAndCountryAll, AllAndCurrencyAll, AllAndPortAll, AllAndIncotermAll,
                        AllAndNotifyPartyAll, AllAndPaymentTermAll, AllAndEmployeeAll, AllAndContactAll, AllAndAddress,
                        AddressView.AllAndAddressTypeAndCountryAndPort, AllAndCustomer {
        }

        public interface AllAndCustomerAndInvoiceTypeAndExchangeRateAndCurrency
                        extends All, AllAndInvoiceType, AllAndCustomer, AllAndExchangeRate, AllAndCurrencyId {
        }

}
