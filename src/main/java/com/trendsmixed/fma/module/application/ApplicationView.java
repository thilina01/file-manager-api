package com.trendsmixed.fma.module.application;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class ApplicationView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface ShortName {
    }

    public interface All extends Id, Code, Name, ShortName, PageView.All {
    }

}
