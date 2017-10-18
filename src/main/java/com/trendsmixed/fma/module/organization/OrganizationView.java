package com.trendsmixed.fma.module.organization;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class OrganizationView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface Slogan1 {
    }

    public static interface Slogan2 {
    }

    public static interface Vat {
    }

    public static interface Svat {
    }

    public static interface All extends Id, Code, Name, Slogan1, Slogan2, Vat, Svat, PageView.All {
    }

}
