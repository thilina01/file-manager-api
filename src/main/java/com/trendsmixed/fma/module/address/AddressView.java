package com.trendsmixed.fma.module.address;

import com.trendsmixed.fma.module.addresstype.AddressTypeView;
import com.trendsmixed.fma.module.country.CountryView;
import com.trendsmixed.fma.module.dispatchnote.DispatchNoteView;
import com.trendsmixed.fma.module.port.PortView;
import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class AddressView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface Line1 {
    }

    public interface Line2 {
    }

    public interface Line3 {
    }

    public interface Line4 {
    }

    public interface Line5 {
    }

    public interface AddressType {
    }

    public interface Country {
    }

    public interface Port {
    }

    public interface Customer {
    }

    public interface All extends Id, Code, Name, Line1, Line2, Line3, Line4, Line5, PageView.All {
    }

    public interface AllAndAddressTypeAll extends All, AddressType, AddressTypeView.All {
    }

    public interface AllAndPortAll extends All, Port, PortView.All {
    }

    public interface AllAndCountryAll extends All, Country, CountryView.All {
    }

    public interface AllAndCustomerAll extends All, Customer, CustomerView.All {
    }

    public interface AllAndAddressTypeAllAndCountryAll extends AllAndAddressTypeAll, Country, CountryView.All {
    }

    public interface DispatchNote extends DispatchNoteView.All {
    }

    public interface AllAndAddressTypeAllAndCountryAllAndPortAll
            extends AllAndAddressTypeAll, Country, CountryView.All, Port, PortView.All {
    }

    public interface AllAndAddressTypeAndCountryAndPort extends All, AllAndCountryAll, AllAndPortAll,AllAndAddressTypeAll {
    }

}
