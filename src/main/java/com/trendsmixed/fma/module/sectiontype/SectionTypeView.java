package com.trendsmixed.fma.module.sectiontype;

import com.trendsmixed.fma.utility.PageView;

public class SectionTypeView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface All extends Id, Code, Name, PageView.All {
    }

}
