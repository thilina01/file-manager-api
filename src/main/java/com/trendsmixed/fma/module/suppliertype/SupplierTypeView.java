package com.trendsmixed.fma.module.suppliertype;

import com.trendsmixed.fma.utility.PageView;

public class SupplierTypeView {

    public static interface Id {
    }

    public static interface Name {
    }

    public static interface Code {
    }

    public static interface All extends Id, Name, Code, PageView.All {
    }

}
