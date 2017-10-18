package com.trendsmixed.fma.module.incoterm;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class IncotermView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface All extends Id, Code, Name, PageView.All {
    }
}
