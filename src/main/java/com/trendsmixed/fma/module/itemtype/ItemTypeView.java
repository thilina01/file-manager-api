package com.trendsmixed.fma.module.itemtype;

import com.trendsmixed.fma.utility.PageView;

public class ItemTypeView {

    public static interface Id {
    }

    public static interface Name {
    }

    public static interface Code {
    }

    public static interface All extends Id, Name, Code, PageView.All {
    }

}
