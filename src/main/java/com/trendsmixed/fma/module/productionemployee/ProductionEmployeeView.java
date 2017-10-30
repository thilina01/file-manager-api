package com.trendsmixed.fma.module.productionemployee;

import com.trendsmixed.fma.module.production.ProductionView;
import com.trendsmixed.fma.module.employee.EmployeeView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class ProductionEmployeeView {

    public interface Id {
    }

    public interface Production {
    }

    public interface Employee {
    }

    public interface All extends Id, PageView.All {
    }

    public interface AllAndProductionAll extends All, Production, ProductionView.All {
    }

    public interface AllAndEmployeeAll extends All, Employee, EmployeeView.All {
    }

}
