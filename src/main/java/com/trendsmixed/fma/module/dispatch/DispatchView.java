package com.trendsmixed.fma.module.dispatch;

import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.module.dispatchnote.DispatchNoteView;
import com.trendsmixed.fma.module.dispatchschedule.DispatchScheduleView;
import com.trendsmixed.fma.module.jobdispatch.JobDispatchView;
import static javafx.scene.input.KeyCode.F;

public class DispatchView {

    public static interface Id {
    }

    public static interface Customer {
    }

    public static interface JobDispatch {
    }

    public static interface DispatchSchedule {
    }

    public static interface DispatchNote {
    }

    public static interface Quantity {
    }

    public static interface All extends Id, Quantity {
    }

    public static interface AllAndCustomerAll extends All, Customer, CustomerView.All {
    }

    public static interface AllAndDispatchScheduleAll extends All, DispatchSchedule, DispatchScheduleView.All {
    }

    public static interface AllAndDispatchNoteAll extends All, DispatchNote, DispatchNoteView.All {
    }

    public static interface AllAndCustomerAllAndJobDispatchAll extends All, Customer, CustomerView.All, JobDispatch, JobDispatchView.All {
    }

}
