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
<<<<<<< HEAD

=======
>>>>>>> 6648fe891a8c247bab85b3ac3e035908546db95b
        }

        public interface All extends Id, DateOfCreditNote, CreditNoteNumber, PageView.All {
        }

        public interface AllAndInvoice extends All, Invoice, InvoiceView.All {
        }

        public interface AllAndInvoiceType extends All, InvoiceType, InvoiceTypeView.All {
        }

<<<<<<< HEAD
        public interface AllAndAddressAndCountry extends All, AddressView.AllAndCountryAll {
        }

        public interface AllAndCreditNoteItem extends All, CreditNoteItem, CreditNoteItemView.All {
        }

        public interface AllAndInvoiceAndExchangeRate extends All, Invoice, InvoiceView.AllAndExchangeRate {
        }
=======
        public interface AllAndCreditNoteItem extends All, CreditNoteItem, CreditNoteItemView.All {
        }
>>>>>>> 6648fe891a8c247bab85b3ac3e035908546db95b

        public interface AllAndLoadingPlanItemAndLoadingPlan extends All, LoadingPlanItemView.AllAndLoadingPlan {
        }

<<<<<<< HEAD
        public interface AllAndLoadingPlanAndAddressAndCustomer extends All, LoadingPlanView.AllAndAddressAndCustomer {
        }

        public interface AllAndCustomerAndContact extends All, CustomerView.AllAndContactAll {
        }

        public interface AllAndCustomerAndIncotermAndCurrencyAndNotifyPartyAndPaymentTermAndEmployee
                        extends All, CustomerView.AllAndIncotermAndCurrencyAndNotifyPartyAndPaymentTermAndEmployee {
        }

        public interface AllAndCreditNoteItemAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem
                        extends All, CreditNoteItem,
                        CreditNoteItemView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem {
        }

        public interface AllAndCreditNoteItemAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndLoadingPlanAndAddressAndCustomerAndCountryAndIncotermAndCurrencyAndNotifyPartyAndContactAndPaymentTermAndEmployee
                        extends All, CreditNoteItem,
                        CreditNoteItemView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem,
                        LoadingPlanItemView.AllAndLoadingPlan, LoadingPlanView.AllAndAddressAndCustomer,
                        AddressView.AllAndCountryAll, AllAndInvoiceAndExchangeRate, AllAndInvoiceType,
                        CustomerView.AllAndIncotermAndCurrencyAndNotifyPartyAndPaymentTermAndEmployee,
                        AllAndCustomerAndContact {

=======
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
>>>>>>> 6648fe891a8c247bab85b3ac3e035908546db95b
        }

}
