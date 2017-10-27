package com.trendsmixed.fma.module.computertype;

import com.trendsmixed.fma.utility.PageView;

public class ComputerTypeView {

    public interface Id {
    }

    public interface Name {
    }

    public interface Code {
    }

    public interface All extends Id, Name, Code, PageView.All {
    }

}
