package com.trendsmixed.fma.module.jobtype;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class JobTypeView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface All extends Id, Name, Code, PageView.All {
    }

}
