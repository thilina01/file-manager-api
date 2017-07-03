package com.trendsmixed.fma.module.shifttype;

import com.trendsmixed.fma.utility.PageView;

public class ShiftTypeView {

    public static interface Id {
    }
    
    public static interface Code {
    }

    public static interface Name {
    }

    public static interface All extends Id, Name, Code, PageView.All {
    }

}
