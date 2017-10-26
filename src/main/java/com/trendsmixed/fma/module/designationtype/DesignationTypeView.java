package com.trendsmixed.fma.module.designationtype;

import com.trendsmixed.fma.utility.PageView;

public class DesignationTypeView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface All extends Id, Name, Code, PageView.All {
    }

}
