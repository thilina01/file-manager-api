package com.trendsmixed.fma.module.paint;

import com.trendsmixed.fma.utility.PageView;

public class PaintView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface All extends Id, Code, Name, PageView.All {
    }

}
