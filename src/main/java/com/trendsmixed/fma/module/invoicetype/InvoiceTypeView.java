package com.trendsmixed.fma.module.invoicetype;

import com.trendsmixed.fma.utility.PageView;

public class InvoiceTypeView {

    public static interface Id {
    }

    public static interface Name {
    }

    public static interface Code {
    }

    public static interface All extends Id, Name, Code, PageView.All {
    }

}
