package com.trendsmixed.fma.module.manpowertype;

import com.trendsmixed.fma.utility.PageView;

public class ManpowerTypeView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface All extends Id, Code, Name, PageView.All {

    }

    public static interface PlanDateManpower {
    }

    public static interface RunDateManpower {
    }

}
