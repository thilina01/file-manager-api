package com.trendsmixed.fma.module.job;

import com.trendsmixed.fma.module.item.ItemView;
import com.trendsmixed.fma.module.jobtype.JobTypeView;
import com.trendsmixed.fma.utility.PageView;

public class JobView {

    public static interface Id {
    }

    public static interface JobNo {
    }

    public static interface Quantity {
    }

    public static interface JobDate {
    }

    public static interface All extends Id, JobNo, Quantity, JobDate, PageView.All {
    }

    public static interface Item {
    }

    public static interface JobType {
    }

    public static interface AllAndItemAll extends All, Item, ItemView.All {
    }

    public static interface AllAndItemAllAndJobTypeAll extends AllAndItemAll, JobType, JobTypeView.All {
    }

}
