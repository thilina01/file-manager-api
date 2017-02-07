package com.trendsmixed.fma.module.dispatch;

import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.module.jobdispatch.JobDispatchView;

public class DispatchView {

    public static interface Id {
    }

    public static interface DispatchDate {
    }

    public static interface Customer {
    }

    public static interface JobDispatch {
    }

    public static interface All extends Id, DispatchDate {
    }

    public static interface AllAndCustomerAll extends All, Customer, CustomerView.All {
    }

    public static interface AllAndCustomerAllAndJobDispatchAll extends All, Customer, CustomerView.All,JobDispatch,JobDispatchView.All {
    }

}
