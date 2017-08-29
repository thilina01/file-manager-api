package com.trendsmixed.fma.module.addresstype;

import com.trendsmixed.fma.utility.PageView;

public class AddressTypeView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface All extends Id, Code, Name, PageView.All {
    }

}
