package com.trendsmixed.fma.module.customer;

import com.trendsmixed.fma.module.address.AddressView;
import com.trendsmixed.fma.module.contact.ContactView;
import com.trendsmixed.fma.module.country.CountryView;
import com.trendsmixed.fma.module.currency.CurrencyView;
import com.trendsmixed.fma.module.customeritem.CustomerItemView;
import com.trendsmixed.fma.module.incoterm.IncotermView;
import com.trendsmixed.fma.module.customertype.CustomerTypeView;
import com.trendsmixed.fma.module.notifyparty.NotifyPartyView;
import com.trendsmixed.fma.module.paymentterm.PaymentTermView;
import com.trendsmixed.fma.utility.PageView;

public class CustomerView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface ShortName {
    }

    public static interface Consignee {
    }

    public static interface Contact {
    }

    public static interface Continent {
    }

    public static interface Fax {
    }

    public static interface ContactNumber {
    }

    public static interface FinalDestination {
    }

    public static interface NotifyParty {
    }

    public static interface Note {
    }

    public static interface SpecialRequirements {
    }

    public static interface OfficeAddress {
    }

    public static interface PaymentTerm {
    }

    public static interface PhoneNo {
    }

    public static interface SVatNo {
    }

    public static interface VatNo {
    }

    public static interface Incoterm {
    }

    public static interface CustomerType {
    }

    public static interface Country {
    }

    public static interface Currency {
    }

    public static interface CustomerItemList {
    }

    public static interface Address {
    }

    public static interface All extends Id, Code, Name, ShortName, Consignee, Contact, Continent, Fax, FinalDestination, Note, SpecialRequirements, OfficeAddress, PhoneNo, SVatNo, VatNo, PageView.All {
    }

    public static interface AllAndIncotermAll extends All, Incoterm, IncotermView.All {
    }

    public static interface AllAndCustomerTypeAll extends All, CustomerType, CustomerTypeView.All {
    }


    public static interface AllAndPaymentTermAll extends All, PaymentTerm, PaymentTermView.All {
    }

    public static interface AllAndNotifyPartyAll extends All, NotifyParty, NotifyPartyView.All {
    }

    public static interface AllAndCurrencyAll extends All, Currency, CurrencyView.All {
    }

    public static interface AllAndCustomerItemList extends All, CustomerItemList, CustomerItemView.All {
    }

    public static interface AllAndContactAll extends All, Contact, ContactView.All {
    }

    public static interface AllAndAddressAll extends All, Address, AddressView.All {
    }    

    public static interface AllAndCustomerItemListAndItemAll extends All, CustomerItemList, CustomerItemView.AllAndItemAll {
    }

    public static interface AllAndIncotermAllAndCustomerTypeAllAndCurrencyAllAndCustomerItemList extends All, Incoterm, IncotermView.All, CustomerType, CustomerTypeView.All, Currency, CurrencyView.All, AllAndCustomerItemList {
    }

    public static interface AllAndIncotermAllAndCustomerTypeAllAndCurrencyAllAndCustomerItemListAndItemAll extends All, Incoterm, IncotermView.All, CustomerType, CustomerTypeView.All, Currency, CurrencyView.All, AllAndCustomerItemListAndItemAll {
    }

    public static interface AllAndIncotermAllAndCustomerTypeAllAndCurrencyAll extends All, Incoterm, IncotermView.All, CustomerType, CustomerTypeView.All, Currency, CurrencyView.All {
    }

    public static interface AllAndIncotermAllAndCustomerTypeAllAndCurrencyAllAndNotifyPartyAllAndContactAllAndContactTypeAllAndPaymentTermAllAndAddressAllAndAddressTypeAllAndCountryAll extends AllAndIncotermAllAndCustomerTypeAllAndCurrencyAll, AllAndNotifyPartyAll, AllAndPaymentTermAll, Address, AddressView.AllAndAddressTypeAllAndCountryAll, Contact, ContactView.AllAndContactTypeAll {
    }

}
