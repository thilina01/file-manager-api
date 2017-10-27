package com.trendsmixed.fma.module.organization;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class OrganizationView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface Slogan1 {
    }

    public interface Slogan2 {
    }

    public interface Vat {
    }

    public interface Svat {
    }

    public interface Address1 {
    }

    public interface Address2 {
    }

    public interface Address3 {
    }

    public interface Address4 {
    }

    public static interface Address5 {
    }

    public static interface All extends Id, Code, Name, Slogan1, Slogan2, Vat, Svat, Address1, Address2, Address3, Address4, Address5, PageView.All {
    }

}
