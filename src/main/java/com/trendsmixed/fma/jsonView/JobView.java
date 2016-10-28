package com.trendsmixed.fma.jsonView;

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

    public static interface JobDate {
    }

    public static interface Comment {
    }

    public static interface All extends Id, JobNo, ActualShippedDate, ConfirmShippedDate, Quantity, JobDate, Comment {

    }

    public static interface Item {

    }

    public static interface SalesOrder {

    }

}
