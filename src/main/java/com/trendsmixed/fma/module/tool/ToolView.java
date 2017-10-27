package com.trendsmixed.fma.module.tool;

import com.trendsmixed.fma.utility.PageView;

public class ToolView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface All extends Id, Code, Name, PageView.All {

    }

}
