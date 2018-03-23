package com.trendsmixed.fma.module.port;

import com.trendsmixed.fma.utility.PageView;

import com.trendsmixed.fma.module.address.AddressView;
import com.trendsmixed.fma.module.address.AddressView.Customer;


public class PortView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface Address {
    }

    public interface All extends Id, Code, Name, PageView.All {
    }

    public interface AllAndAddressAll extends All, Address, AddressView.All {
    }

    public interface AllAndCustomerAll extends All, Customer, AddressView.All {
    }

    public interface AllAndAddressAndCustomerAll extends All, Address,AllAndCustomerAll, AddressView.All {
    }
}
