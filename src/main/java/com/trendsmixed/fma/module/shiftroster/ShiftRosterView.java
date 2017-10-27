package com.trendsmixed.fma.module.shiftroster;

import com.trendsmixed.fma.utility.PageView;

public class ShiftRosterView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface All extends Id, Name, Code, PageView.All {
    }

}
