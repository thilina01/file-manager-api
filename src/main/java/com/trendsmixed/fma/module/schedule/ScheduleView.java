package com.trendsmixed.fma.module.schedule;

import com.trendsmixed.fma.module.operationdemand.OperationDemandView;
import com.trendsmixed.fma.module.shift.ShiftView;
import com.trendsmixed.fma.utility.PageView;

public class ScheduleView {

    public interface Id {
    }

    public interface Quantity {
    }

    public interface ScheduleDate {
    }

    public interface Shift extends ShiftView.All {
    }

    public interface OperationDemand extends OperationDemandView.All {
    }

    public interface All extends Id, Quantity, ScheduleDate, PageView.All {
    }

}
