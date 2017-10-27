package com.trendsmixed.fma.module.department;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class DepartmentView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface All extends Id, Code, Name, PageView.All {
    }
}
