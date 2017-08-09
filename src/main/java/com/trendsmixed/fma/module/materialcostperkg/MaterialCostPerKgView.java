/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.materialcostperkg;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class MaterialCostPerKgView {

    public static interface Id {
    }

    public static interface EffectiveMonth {
    }

    public static interface Actual {
    }

    public static interface Budget {
    }

    public static interface All extends Id, EffectiveMonth, Actual, Budget, PageView.All {
    }

}
