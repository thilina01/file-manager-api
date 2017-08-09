package com.trendsmixed.fma.module.jobdispatch;

import com.trendsmixed.fma.module.dispatch.DispatchView;
import com.trendsmixed.fma.module.job.JobView;

public class JobDispatchView {

    public static interface Id {
    }

    public static interface Quantity {
    }

    public static interface Dispatch {
    }

    public static interface Job {
    }

    public static interface All extends Id, Quantity {
    }

    public static interface AllAndDispatchAllAndJobAll extends All, Dispatch, Job, DispatchView.All, JobView.All {
    }

    public static interface AllAndDispatchAllAndJobAllAndItemAll extends All, Dispatch, Job, DispatchView.All, JobView.AllAndItemAllAndJobTypeAll {
    }

    public static interface AllAndDispatchAllAndCustomerAllAndJobAllAndItemAll extends All, Dispatch, Job, DispatchView.AllAndCustomerAll, JobView.AllAndItemAllAndJobTypeAll {
    }

}
