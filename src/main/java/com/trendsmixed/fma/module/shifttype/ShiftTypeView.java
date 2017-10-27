package com.trendsmixed.fma.module.shifttype;

import com.trendsmixed.fma.utility.PageView;

public class ShiftTypeView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface All extends Id, Name, Code, PageView.All {
    }

}
