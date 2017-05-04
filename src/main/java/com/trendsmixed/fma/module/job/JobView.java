package com.trendsmixed.fma.module.job;

import com.trendsmixed.fma.module.item.ItemView;
import com.trendsmixed.fma.module.jobtype.JobTypeView;
import com.trendsmixed.fma.utility.PageView;

public class JobView {

    public static interface Id {
    }

    public static interface JobNo {
    }

    public static interface ActualShippedDate {
    }

    public static interface ConfirmShippedDate {
    }

    public static interface Quantity {
    }

    public static interface RemainingQuantity {
    }

    public static interface JobDate {
    }

    public static interface Comment {
    }

    public static interface All extends Id, JobNo, ActualShippedDate, ConfirmShippedDate, Quantity, RemainingQuantity, JobDate, Comment, PageView.All {
    }

    public static interface Item {
    }

    public static interface JobType {
    }

    public static interface SalesOrderItem {
    }

    public static interface AllAndItemAllAndJobTypeAll extends All, Item, JobType, ItemView.All, JobTypeView.AlL {
    }

}
