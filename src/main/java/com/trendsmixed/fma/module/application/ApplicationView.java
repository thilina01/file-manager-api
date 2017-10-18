package com.trendsmixed.fma.module.application;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class ApplicationView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface ShortName {
    }

    public static interface All extends Id, Code, Name, ShortName, PageView.All {
    }

}
