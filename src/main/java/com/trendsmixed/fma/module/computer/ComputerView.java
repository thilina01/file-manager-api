package com.trendsmixed.fma.module.computer;

import com.trendsmixed.fma.module.computertype.ComputerTypeView;
import com.trendsmixed.fma.module.employee.EmployeeView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class ComputerView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Ram {
    }

    public static interface Model {
    }

    public static interface Brand {
    }

    public static interface Processor {
    }

    public static interface Hdd1 {
    }

    public static interface Hdd2 {
    }

    public static interface LanMac {
    }

    public static interface WlanMac {
    }

    public static interface LanIp {
    }

    public static interface WlanIp {
    }

    public static interface Value {
    }

    public static interface ShortName {
    }

    public static interface PurchaseDate {
    }

    public static interface TransferDate {
    }

    public static interface Employee {
    }

    public static interface ComputerType {
    }

    public static interface All extends Id, Code, Brand, Model, Ram, Processor, Hdd1, Hdd2, LanMac, WlanMac, LanIp, WlanIp, Value, PurchaseDate, TransferDate, PageView.All {
    }

    public static interface AllAndEmployeeAll extends All, Employee, EmployeeView.All {
    }

    public static interface AllAndComputerTypeAll extends All, ComputerType, ComputerTypeView.All {
    }

    public static interface AllAndEmployeeAllAndComputerTypeAll extends All, Employee, EmployeeView.All, ComputerType, ComputerTypeView.All {
    }

}
