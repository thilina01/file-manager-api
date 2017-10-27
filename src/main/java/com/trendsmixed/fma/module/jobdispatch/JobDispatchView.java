package com.trendsmixed.fma.module.jobdispatch;

import com.trendsmixed.fma.module.dispatch.DispatchView;
import com.trendsmixed.fma.module.job.JobView;

public class JobDispatchView {

    public interface Id {
    }

    public interface Quantity {
    }

    public interface Dispatch {
    }

    public interface Job {
    }

    public interface All extends Id, Quantity {
    }

    public interface AllAndDispatchAllAndJobAll extends All, Dispatch, Job, DispatchView.All, JobView.All {
    }

    public interface AllAndDispatchAllAndJobAllAndItemAll extends All, Dispatch, Job, DispatchView.All, JobView.AllAndItemAllAndJobTypeAll {
    }

    public interface AllAndDispatchAllAndCustomerAllAndJobAllAndItemAll extends All, Dispatch, Job, DispatchView.AllAndCustomerAll, JobView.AllAndItemAllAndJobTypeAll {
    }

}
