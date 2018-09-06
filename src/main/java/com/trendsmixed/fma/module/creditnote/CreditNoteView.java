package com.trendsmixed.fma.module.creditnote;

import com.trendsmixed.fma.module.invoice.InvoiceView;
import com.trendsmixed.fma.module.loadingplan.LoadingPlanView;
import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.module.address.AddressView;
import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItemView;
import com.trendsmixed.fma.module.creditnoteitem.CreditNoteItemView;
import com.trendsmixed.fma.module.invoicetype.InvoiceTypeView;

import com.trendsmixed.fma.utility.PageView;

public class CreditNoteView {

        public interface Id {
        }

        public interface Invoice {
        }

        public interface CreditNoteItem {
        }

        public interface DateOfCreditNote {
        }

        public interface CreditNoteNumber {
        }

        public interface InvoiceType {
        }

        public interface All extends Id, DateOfCreditNote, CreditNoteNumber, PageView.All {
        }

        public interface AllAndInvoice extends All, Invoice, InvoiceView.All {
        }

        public interface AllAndInvoiceType extends All, InvoiceType, InvoiceTypeView.All {
        }

        public interface AllAndCreditNoteItem extends All, CreditNoteItem, CreditNoteItemView.All {
        }

        public interface AllAndLoadingPlanItemAndLoadingPlan extends All, LoadingPlanItemView.AllAndLoadingPlan {
        }

        public interface AllAndLoadingPlanItemAndLoadingPlanAndContainerSizeAndAddressAndCustomer
                        extends All, LoadingPlanView.AllAndPortOfLoadingAndContainerSizeAndAddressAndCustomer {
        }

        public interface AllAndInvoiceAndAllAndExchangeRate extends All, Invoice, InvoiceView.AllAndExchangeRate {
        }

        public interface AllAndAddressAndCountry extends All, AddressView.AllAndAddressTypeAndCountryAndPort {
        }

        public interface AllAndCustomerAndIncotermAndCurrencyAndNotifyPartyAndContactAndPaymentTermAndCountryAndEmployeeAndContact
                        extends All,
                        CustomerView.AllAndIncotermAllAndCustomerTypeAllAndCurrencyAllAndNotifyPartyAllAndContactAllAndContactTypeAllAndPaymentTermAllAndAddressAllAndAddressTypeAllAndCountryAllAndPortAllAndEmployeeAll {
        }

        public interface AllAndCreditNoteItemAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPalletSize
                        extends All, CreditNoteItem,
                        CreditNoteItemView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPalletSize {
        }

        public interface AllAndCreditNoteItemAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPalletSizeAndLoadingPlanAndContainerSizeAndAddressAndCustomerAndInvoiceAndExchangeRate
                        extends All,
                        AllAndCreditNoteItemAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPalletSize,
                        AllAndLoadingPlanItemAndLoadingPlanAndContainerSizeAndAddressAndCustomer,
                        AllAndLoadingPlanItemAndLoadingPlan,
                        AllAndCustomerAndIncotermAndCurrencyAndNotifyPartyAndContactAndPaymentTermAndCountryAndEmployeeAndContact,
                        AllAndInvoiceAndAllAndExchangeRate, AllAndInvoiceType, AllAndAddressAndCountry {
        }

}
