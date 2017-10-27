package com.trendsmixed.fma.module.shift;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class ShiftView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {

    }

    public interface All extends Id, Code, Name, PageView.All {

    }

}
