package com.trendsmixed.fma.module.manpower;

import com.trendsmixed.fma.module.manpowertype.ManpowerTypeView;
import com.trendsmixed.fma.module.production.ProductionView;

/**
 *
 * @author Thilina
 */
public class ManpowerView {

    public interface Id {
    }

    public interface PlannedQuantity {
    }

    public interface ActualQuantity {
    }

    public interface ManpowerType extends ManpowerTypeView.All {
    }

    public interface Production extends ProductionView.AllAndShiftAndShiftTypeAndControlPointAll {
    }

    public interface All extends Id, PlannedQuantity, ActualQuantity {
    }

    public interface AllManpowerTypeAll extends All, ManpowerType {
    }

    public interface AllManpowerTypeAllProductionAll extends AllManpowerTypeAll, Production {
    }

}
