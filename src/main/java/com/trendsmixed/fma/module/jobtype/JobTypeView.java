package com.trendsmixed.fma.module.jobtype;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class JobTypeView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface All extends Id, Name, Code, PageView.All {
    }

}
