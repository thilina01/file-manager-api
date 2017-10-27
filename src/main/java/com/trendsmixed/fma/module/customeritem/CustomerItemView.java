package com.trendsmixed.fma.module.customeritem;

import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.module.item.ItemView;
import com.trendsmixed.fma.utility.PageView;

public class CustomerItemView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface Price {
    }

    public interface Customer {
    }

    public interface Item {
    }

    public interface All extends Id, Code, Name, Price, PageView.All {
    }

    public interface AllAndCustomerAll extends All, Customer, CustomerView.All {
    }

    public static interface AllAndItemAll extends All, Item, ItemView.All {
    }

    public static interface AllAndCustomerAllAndItemAll extends All, Customer, CustomerView.All, Item, ItemView.All {
    }

}
