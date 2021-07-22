package com.trendsmixed.fma.module.warehouse;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class WarehouseView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {

    }

    public interface All extends Id, Code, Name, PageView.All {

    }

}
