package com.trendsmixed.fma.module.contacttype;

import com.trendsmixed.fma.utility.PageView;

public class ContactTypeView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface All extends Id, Code, Name, PageView.All {
    }

}
