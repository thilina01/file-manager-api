package com.trendsmixed.fma.module.standardunit;

import com.trendsmixed.fma.utility.PageView;

public class StandardUnitView {

    public interface Id {
    }

    public interface Name {
    }

    public interface Code {
    }

    public interface All extends Id, Name, Code, PageView.All {
    }

}
