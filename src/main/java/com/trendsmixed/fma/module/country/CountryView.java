package com.trendsmixed.fma.module.country;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class CountryView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface All extends Id, Code, Name, PageView.All {
    }

}
