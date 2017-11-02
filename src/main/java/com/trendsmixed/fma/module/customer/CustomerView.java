package com.trendsmixed.fma.module.customer;

import com.trendsmixed.fma.module.address.AddressView;
import com.trendsmixed.fma.module.contact.ContactView;
import com.trendsmixed.fma.module.currency.CurrencyView;
import com.trendsmixed.fma.module.customeritem.CustomerItemView;
import com.trendsmixed.fma.module.incoterm.IncotermView;
import com.trendsmixed.fma.module.customertype.CustomerTypeView;
import com.trendsmixed.fma.module.dispatchnote.DispatchNoteView;
import com.trendsmixed.fma.module.invoice.InvoiceView;
import com.trendsmixed.fma.module.notifyparty.NotifyPartyView;
import com.trendsmixed.fma.module.paymentterm.PaymentTermView;
import com.trendsmixed.fma.utility.PageView;

public class CustomerView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface ShortName {
    }

    public interface Consignee {
    }

    public interface Contact {
    }

    public interface Continent {
    }

    public interface Fax {
    }

    public interface ContactNumber {
    }

    public interface FinalDestination {
    }

    public interface NotifyParty {
    }

    public interface Note {
    }

    public interface SpecialRequirements {
    }

    public interface OfficeAddress {
    }

    public interface PaymentTerm {
    }

    public interface PhoneNo {
    }

    public interface SVatNo {
    }

    public interface VatNo {
    }

    public interface Incoterm {
    }

    public interface CustomerType {
    }

    public interface Country {
    }

    public interface Currency {
    }

    public interface CustomerItemList {
    }

    public interface Address {
    }

    public interface DispatchNote {
    }

    public interface Invoice {
    }

    public interface All extends Id, Code, Name, ShortName, Consignee, Contact, Continent, Fax, FinalDestination, Note, SpecialRequirements, OfficeAddress, PhoneNo, SVatNo, VatNo, PageView.All {
    }

    public interface AllAndIncotermAll extends All, Incoterm, IncotermView.All {
    }

    public interface AllAndInvoiceAll extends All, Invoice, InvoiceView.All {
    }

    public interface AllAndCustomerTypeAll extends All, CustomerType, CustomerTypeView.All {
    }

    public interface AllAndPaymentTermAll extends All, PaymentTerm, PaymentTermView.All {
    }

    public interface AllAndNotifyPartyAll extends All, NotifyParty, NotifyPartyView.All {
    }

    public interface AllAndCurrencyAll extends All, Currency, CurrencyView.All {
    }

    public interface AllAndCustomerItemList extends All, CustomerItemList, CustomerItemView.All {
    }

    public interface AllAndContactAll extends All, Contact, ContactView.All {
    }

    public interface AllAndAddressAll extends All, Address, AddressView.All {
    }

    public interface AllAndDispatchNoteAll extends All, DispatchNote, DispatchNoteView.All {
    }

    public interface AllAndCustomerItemListAndItemAll extends All, CustomerItemList, CustomerItemView.AllAndItemAll {
    }

    public interface AllAndIncotermAllAndCustomerTypeAllAndCurrencyAllAndCustomerItemList extends All, Incoterm, IncotermView.All, CustomerType, CustomerTypeView.All, Currency, CurrencyView.All, AllAndCustomerItemList {
    }

    public interface AllAndIncotermAllAndCustomerTypeAllAndCurrencyAllAndCustomerItemListAndItemAll extends All, Incoterm, IncotermView.All, CustomerType, CustomerTypeView.All, Currency, CurrencyView.All, AllAndCustomerItemListAndItemAll {
    }

    public interface AllAndIncotermAllAndCustomerTypeAllAndCurrencyAll extends All, Incoterm, IncotermView.All, CustomerType, CustomerTypeView.All, Currency, CurrencyView.All {
    }

    public interface AllAndIncotermAllAndCustomerTypeAllAndCurrencyAllAndNotifyPartyAllAndContactAllAndContactTypeAllAndPaymentTermAllAndAddressAllAndAddressTypeAllAndCountryAll extends AllAndIncotermAllAndCustomerTypeAllAndCurrencyAll, AllAndNotifyPartyAll, AllAndPaymentTermAll, Address, AddressView.AllAndAddressTypeAllAndCountryAll, Contact, ContactView.AllAndContactTypeAll {
    }

}
