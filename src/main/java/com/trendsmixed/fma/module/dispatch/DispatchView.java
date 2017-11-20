package com.trendsmixed.fma.module.dispatch;

import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.module.dispatchnote.DispatchNoteView;
import com.trendsmixed.fma.module.dispatchschedule.DispatchScheduleView;
import com.trendsmixed.fma.module.jobdispatch.JobDispatchView;

public class DispatchView {

    public interface Id {
    }

    public interface Customer {
    }

    public interface JobDispatch {
    }

    public interface DispatchSchedule {
    }

    public interface DispatchNote {
    }

    public interface Quantity {
    }

    public interface All extends Id, Quantity {
    }

    public interface AllAndCustomerAll extends All, Customer, CustomerView.All {
    }

    public interface AllAndDispatchScheduleAll extends All, DispatchSchedule, DispatchScheduleView.All {
    }

    public interface AllAndDispatchNoteAll extends All, DispatchNote, DispatchNoteView.All {
    }

    public interface AllAndCustomerAllAndJobDispatchAll extends All, Customer, CustomerView.All, JobDispatch, JobDispatchView.All {
    }

    public interface AllAndDispatchScheduleAndJobAndItem extends All, DispatchSchedule, DispatchScheduleView.AllAndJobAndItem{
    }

    public interface AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem extends All, DispatchSchedule, DispatchScheduleView.AllAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem{
    }
}
