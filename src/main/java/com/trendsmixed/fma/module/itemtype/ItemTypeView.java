package com.trendsmixed.fma.module.itemtype;

import com.trendsmixed.fma.utility.PageView;

public class ItemTypeView {

    public interface Id {
    }

    public interface Name {
    }

    public interface Code {
    }

    public interface All extends Id, Name, Code, PageView.All {
    }

}
