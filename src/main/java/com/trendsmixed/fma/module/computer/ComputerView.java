package com.trendsmixed.fma.module.computer;

import com.trendsmixed.fma.module.computertype.ComputerTypeView;
import com.trendsmixed.fma.module.employee.EmployeeView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class ComputerView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Ram {
    }

    public interface Model {
    }

    public interface Brand {
    }

    public interface Processor {
    }

    public interface Hdd1 {
    }

    public interface Hdd2 {
    }

    public interface LanMac {
    }

    public interface WlanMac {
    }

    public interface LanIp {
    }

    public interface WlanIp {
    }

    public interface Value {
    }

    public interface ShortName {
    }

    public interface PurchaseDate {
    }

    public interface TransferDate {
    }

    public interface Employee {
    }

    public interface ComputerType {
    }

    public interface All extends Id, Code, Brand, Model, Ram, Processor, Hdd1, Hdd2, LanMac, WlanMac, LanIp, WlanIp, Value, PurchaseDate, TransferDate, PageView.All {
    }

    public interface AllAndEmployeeAll extends All, Employee, EmployeeView.All {
    }

    public interface AllAndComputerTypeAll extends All, ComputerType, ComputerTypeView.All {
    }

    public interface AllAndEmployeeAllAndComputerTypeAll extends All, Employee, EmployeeView.All, ComputerType, ComputerTypeView.All {
    }

}
