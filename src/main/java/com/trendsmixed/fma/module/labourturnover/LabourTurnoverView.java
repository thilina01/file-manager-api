/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.labourturnover;

import com.trendsmixed.fma.module.labourtursource.LabourSourceView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class LabourTurnoverView {

    public static interface Id {
    }

    public static interface Turnover {
    }

    public static interface Target {
    }

    public static interface LabourSource extends LabourSourceView.All {
    }

    public static interface All extends Id, Turnover, Target, PageView.All {
    }

    public static interface AllAndLabourSource extends All, LabourSource {
    }
}
