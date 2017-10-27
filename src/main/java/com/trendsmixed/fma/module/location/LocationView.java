package com.trendsmixed.fma.module.location;

import com.trendsmixed.fma.utility.PageView;

public class LocationView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface All extends Id, Code, Name, PageView.All {

    }

}
