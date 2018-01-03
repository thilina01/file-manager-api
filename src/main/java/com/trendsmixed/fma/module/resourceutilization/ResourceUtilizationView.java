package com.trendsmixed.fma.module.resourceutilization;

import com.trendsmixed.fma.module.employee.EmployeeView;
import com.trendsmixed.fma.module.machine.MachineView;
import com.trendsmixed.fma.module.production.ProductionView;
import com.trendsmixed.fma.module.shift.ShiftView;
import com.trendsmixed.fma.module.production.ProductionView.ControlPoint;
import com.trendsmixed.fma.module.production.ProductionView.Shift;
import com.trendsmixed.fma.utility.PageView;

public class ResourceUtilizationView {

        public interface Id {
        }

        public interface StartTime {
        }

        public interface EndTime {
        }

        public interface Production {
        }

        public interface Employee {
        }

        public interface Machine {
        }

        public interface All extends Id, EndTime, StartTime, PageView.All {
        }

        public interface AllAndEmployeeAll extends All, Employee, EmployeeView.All {
        }

        public interface AllAndMachineAll extends All, Machine, MachineView.All {
        }

        public interface AllAndShiftAll extends All, Shift, ShiftView.All {
        }

        public interface AllAndShiftAndControlPointAll
                        extends All, Shift, ControlPoint, ProductionView.AllAndShiftAndShiftTypeAndControlPointAll {
        }

        public interface AllAndProductionAll extends All, Production, ProductionView.All {
        }

        public static interface AllAndProductionAndShiftAndControlPointAllAndEmployeeAllAndMachineAll
                        extends All, Production, ProductionView.All, AllAndMachineAll, AllAndEmployeeAll,
                        ProductionView.AllAndShiftAndShiftTypeAndControlPointAll {
        }

}
