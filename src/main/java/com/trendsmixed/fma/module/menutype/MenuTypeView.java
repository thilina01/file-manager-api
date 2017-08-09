package com.trendsmixed.fma.module.menutype;

import com.trendsmixed.fma.utility.PageView;

public class MenuTypeView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface All extends Id, Name, Code, PageView.All {
    }

}
