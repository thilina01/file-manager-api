package com.trendsmixed.fma.module.operationdemand;

import com.trendsmixed.fma.module.job.JobView;
import com.trendsmixed.fma.module.routing.RoutingView;
import com.trendsmixed.fma.utility.PageView;

public class OperationDemandView {

    public interface Id {
    }

    public interface Quantity {
    }

    public interface ManufacturedQuantity {
    }

    public interface Job extends JobView.All {
    }

    public interface Routing extends RoutingView.All {
    }


    public interface All extends Id, Quantity, ManufacturedQuantity, PageView.All {
    }

}
