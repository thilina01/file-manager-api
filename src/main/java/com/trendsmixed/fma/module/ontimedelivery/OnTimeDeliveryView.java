package com.trendsmixed.fma.module.ontimedelivery;

import com.trendsmixed.fma.module.customer.CustomerView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class OnTimeDeliveryView {

    public interface Id {
    }

    public interface EffectiveMonth {
    }

    public interface Actual {
    }

    public interface Plan {
    }

    public interface Customer {
    }

    public interface All extends Id, EffectiveMonth, Actual, Plan, PageView.All {
    }

    public interface AllAndCustomerAll extends All, Customer, CustomerView.All {
    }

}
