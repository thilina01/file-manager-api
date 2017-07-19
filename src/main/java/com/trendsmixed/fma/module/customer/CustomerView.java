package com.trendsmixed.fma.module.customer;

import com.trendsmixed.fma.module.country.CountryView;
import com.trendsmixed.fma.module.currency.CurrencyView;
import com.trendsmixed.fma.module.customeritem.CustomerItemView;
import com.trendsmixed.fma.module.incoterm.IncotermView;
import com.trendsmixed.fma.module.customertype.CustomerTypeView;
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

    public static interface All extends Id, Code, Name, ShortName, Consignee, Contact, Continent, Fax, FinalDestination, NotifyParty, Note, SpecialRequirements, OfficeAddress, PaymentTerm, PhoneNo, SVatNo, VatNo, PageView.All {
    }

    public static interface AllAndIncotermAll extends All, Incoterm, IncotermView.All {
    }

    public static interface AllAndCustomerTypeAll extends All, CustomerType, CustomerTypeView.All {
    }

    public static interface AllAndCountryAll extends All, Country, CountryView.All {
    }

    public static interface AllAndCurrencyAll extends All, Currency, CurrencyView.All {
    }

    public static interface AllAndCustomerItemList extends All, CustomerItemList, CustomerItemView.All {
    }

    public static interface AllAndCustomerItemListAndItemAll extends All, CustomerItemList, CustomerItemView.AllAndItemAll {
    }

    public static interface AllAndIncotermAllAndCustomerTypeAllAndCountryAllAndCurrencyAllAndCustomerItemList extends All, Incoterm, IncotermView.All, CustomerType, CustomerTypeView.All, Country, CountryView.All, Currency, CurrencyView.All, AllAndCustomerItemList {
    }

    public static interface AllAndIncotermAllAndCustomerTypeAllAndCountryAllAndCurrencyAllAndCustomerItemListAndItemAll extends All, Incoterm, IncotermView.All, CustomerType, CustomerTypeView.All, Country, CountryView.All, Currency, CurrencyView.All, AllAndCustomerItemListAndItemAll {
    }

    public static interface AllAndIncotermAllAndCustomerTypeAllAndCountryAllAndCurrencyAll extends All, Incoterm, IncotermView.All, CustomerType, CustomerTypeView.All, Country, CountryView.All, Currency, CurrencyView.All {
    }

}
