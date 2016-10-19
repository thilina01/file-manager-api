package com.trendsmixed.fma.jsonView;

public class CustomerView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
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

    public static interface NortifyParty {
    }

    public static interface Note {
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

    public static interface CustType {
    }

    public static interface Country {
    }

    public static interface Currency {
    }

    public static interface All extends Id, Code, Name, Consignee, Contact, Continent, Fax, FinalDestination, NortifyParty, Note, OfficeAddress, PaymentTerm, PhoneNo, SVatNo, VatNo {
    }

    public static interface AllAndIncotermAll extends All, Incoterm, IncotermView.All {
    }

    public static interface AllAndCustTypeAll extends All, CustType, CustTypeView.All {
    }

    public static interface AllAndCountryAll extends All, Country, CountryView.All {
    }

    public static interface AllAndCurrencyAll extends All, Currency, CurrencyView.All {
    }

    public static interface AllAndIncotermAllAndCustTypeAllAndCountryAllAndCurrencyAll extends All, Incoterm, IncotermView.All, CustType, CustTypeView.All, Country, CountryView.All, Currency, CurrencyView.All {
    }
    
}
