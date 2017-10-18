package com.trendsmixed.fma.module.ontimedelivery;

import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class OnTimeDeliveryView {

    public static interface Id {
    }

    public static interface EffectiveMonth {
    }

    public static interface Actual {
    }

    public static interface Plan {
    }

    public static interface Customer {
    }

    public static interface All extends Id, EffectiveMonth, Actual, Plan, PageView.All {
    }

    public static interface AllAndCustomerAll extends All, Customer, CustomerView.All {
    }

}
