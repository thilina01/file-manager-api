package com.trendsmixed.fma.module.rawmaterialitem;

import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class RawMaterialItemView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Description {
    }

    public interface UnitWeight {
    }

    public interface NumberOfPieces {
    }

    public interface All extends Id, Code, Description,UnitWeight,NumberOfPieces,PageView.All {
    }
}
