package com.trendsmixed.fma.module.job;

import com.trendsmixed.fma.module.item.ItemView;
import com.trendsmixed.fma.module.jobtype.JobTypeView;
import com.trendsmixed.fma.utility.PageView;

public class JobView {

    public interface Id {
    }

    public interface JobNo {
    }

    public interface Quantity {
    }

    public interface JobDate {
    }

    public interface All extends Id, JobNo, Quantity, JobDate, PageView.All {
    }

    public interface Item {
    }

    public interface JobType {
    }

    public interface AllAndItemAll extends All, Item, ItemView.All {
    }

    public interface AllAndItemAllAndJobTypeAll extends AllAndItemAll, JobType, JobTypeView.All {
    }

}
