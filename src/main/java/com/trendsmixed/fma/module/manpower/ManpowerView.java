/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.manpower;

import com.trendsmixed.fma.module.manpowertype.ManpowerTypeView;
import com.trendsmixed.fma.module.production.ProductionView;

/**
 *
 * @author Thilina
 */
public class ManpowerView {

    public static interface Id {
    }

    public static interface PlannedQuantity {
    }

    public static interface ActualQuantity {
    }

    public static interface ManpowerType extends ManpowerTypeView.All {
    }

    public static interface Production extends ProductionView.AllAndShiftAndShiftTypeAndControlPointAll {
    }

    public static interface All extends Id, PlannedQuantity, ActualQuantity {
    }

    public static interface AllManpowerTypeAll extends All, ManpowerType {
    }

    public static interface AllManpowerTypeAllProductionAll extends AllManpowerTypeAll, Production {
    }

}
