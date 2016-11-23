package com.trendsmixed.fma.jsonView;

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

}
