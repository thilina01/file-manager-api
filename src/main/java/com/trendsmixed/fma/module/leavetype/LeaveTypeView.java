package com.trendsmixed.fma.module.leavetype;

import com.trendsmixed.fma.utility.PageView;

public class LeaveTypeView {

    public static interface Id {
    }

    public static interface Name {
    }

    public static interface Code {
    }

    public static interface TypeInSinhala {
    }

    public static interface All extends Id, Name, Code, TypeInSinhala, PageView.All {
    }

}
