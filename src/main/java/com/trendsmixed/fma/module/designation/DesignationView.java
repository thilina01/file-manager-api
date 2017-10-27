package com.trendsmixed.fma.module.designation;

import com.trendsmixed.fma.utility.PageView;

public class DesignationView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface All extends Id, Name, Code, PageView.All {
    }

}
