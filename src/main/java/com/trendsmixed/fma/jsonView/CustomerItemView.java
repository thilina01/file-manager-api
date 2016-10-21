package com.trendsmixed.fma.jsonView;

public class CustomerItemView {

    public static interface Id {
    }

    public static interface CustomerPartNo {
    }

    public static interface Price {
    }

    public static interface Customer {
    }

    public static interface Item {
    }

    public static interface All extends Id, CustomerPartNo, Price {
    }

    public static interface AllAndCustomerAll extends All, Customer, CustomerView.All {
    }

    public static interface AllAndItemAll extends All, Item, ItemView.All {
    }

    public static interface AllAndCustomerAllAndItemAll extends All, Customer, CustomerView.All, Item, ItemView.All {
    }

}
