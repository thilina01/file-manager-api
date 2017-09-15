package com.trendsmixed.fma.module.containersize;

import com.trendsmixed.fma.utility.PageView;

public class ContainerSizeView {

    public static interface Id {
    }

    public static interface Name {
    }

    public static interface Code {
    }

    public static interface All extends Id, Name, Code, PageView.All {
    }

}
