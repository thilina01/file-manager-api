package com.trendsmixed.fma.module.rawmaterial;

import com.trendsmixed.fma.utility.PageView;

public class RawMaterialView {

    public interface Id {
    }

    public interface Name {
    }

    public interface Code {
    }

    public interface All extends Id, Name, Code, PageView.All {
    }

}
