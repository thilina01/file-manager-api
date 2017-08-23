package com.trendsmixed.fma.module.sectiontype;

import com.trendsmixed.fma.utility.PageView;

public class SectionTypeView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface All extends Id, Code, Name,PageView.All {
    }

}
