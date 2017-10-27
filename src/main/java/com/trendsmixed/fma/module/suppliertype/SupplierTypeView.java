package com.trendsmixed.fma.module.suppliertype;

import com.trendsmixed.fma.utility.PageView;

public class SupplierTypeView {

    public interface Id {
    }

    public interface Name {
    }

    public interface Code {
    }

    public interface All extends Id, Name, Code, PageView.All {
    }

}
