package com.trendsmixed.fma.module.materialtype;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Thilina
 */
public class MaterialTypeView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Description {
    }

    public interface All extends Id, Description, Code, PageView.All {
    }

}
