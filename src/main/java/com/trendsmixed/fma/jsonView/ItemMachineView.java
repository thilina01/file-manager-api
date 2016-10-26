/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.jsonView;

/**
 *
 * @author Daminda
 */
public class ItemMachineView {

    public static interface ConsumptionRate {

    }

    public static interface Id {
    }

    public static interface Machine {
    }

    public static interface Item {
    }

    public static interface All extends Id, ConsumptionRate, Machine,Item {
    }

}
