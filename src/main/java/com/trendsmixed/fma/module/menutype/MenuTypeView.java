package com.trendsmixed.fma.module.menutype;

import com.trendsmixed.fma.utility.PageView;

public class MenuTypeView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface All extends Id, Name, Code, PageView.All {
    }

}
