package com.trendsmixed.fma.jsonView;

public class DispatchView {

    public static interface Id {
    }

    public static interface DispatchDate {
    }

    public static interface Customer {
    }

    public static interface All extends Id, DispatchDate {
    }

    public static interface AllAndCustomerAll extends All, Customer, CustomerView.All {
    }

}
