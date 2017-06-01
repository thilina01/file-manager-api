/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.labourtursource;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class LabourSourceView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface All extends Id, Code, Name, PageView.All {
    }
}
