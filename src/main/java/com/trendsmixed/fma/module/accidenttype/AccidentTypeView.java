package com.trendsmixed.fma.module.accidenttype;

import com.trendsmixed.fma.utility.PageView;

public class AccidentTypeView {

    public interface Id {
    }

    public interface Name {
    }

    public interface Code {
    }

    public interface All extends Id, Name, Code, PageView.All {
    }

}
