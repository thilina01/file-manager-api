package com.trendsmixed.fma.module.salesperson;

import com.trendsmixed.fma.utility.PageView;

public class SalesPersonView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {

    }

    public interface All extends Id, Code, Name, PageView.All {

    }

}
