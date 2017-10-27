package com.trendsmixed.fma.module.addresstype;

import com.trendsmixed.fma.module.address.AddressView;
import com.trendsmixed.fma.utility.PageView;

public class AddressTypeView {

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
}
