package com.trendsmixed.fma.module.manpowertype;

import com.trendsmixed.fma.utility.PageView;

public class ManpowerTypeView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface All extends Id, Code, Name, PageView.All {

    }

    public interface PlanDateManpower {
    }

    public interface RunDateManpower {
    }

}
