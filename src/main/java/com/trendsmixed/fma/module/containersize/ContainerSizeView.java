package com.trendsmixed.fma.module.containersize;

import com.trendsmixed.fma.utility.PageView;

public class ContainerSizeView {

    public interface Id {
    }

    public interface Name {
    }

    public interface Code {
    }

    public interface All extends Id, Name, Code, PageView.All {
    }

}
