package com.trendsmixed.fma.module.loadingplanitem;

import com.trendsmixed.fma.module.packagingspecification.PackagingSpecificationView;
import com.trendsmixed.fma.module.loadingplan.LoadingPlanView;
import com.trendsmixed.fma.module.dispatchschedule.DispatchScheduleView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Thilina
 */
public class LoadingPlanItemView {

        public interface Id {
        }

        public interface CubicMeter {
        }

        public interface Quantity {
        }

        public interface PackagingSpecification {
        }

        public interface DispatchSchedule {
        }

        public interface LoadingPlan {
        }

        public interface All extends Id, CubicMeter, Quantity, PageView.All {
        }

        public interface AllAndPackagingSpecification
                        extends All, PackagingSpecification, PackagingSpecificationView.All {
        }

        public interface AllAndLoadingPlan extends All, LoadingPlan, LoadingPlanView.All {
        }

        public interface AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem
                        extends All, DispatchSchedule,
                        DispatchScheduleView.AllAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem {
        }

        public interface AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecification
                        extends All, DispatchSchedule,
                        DispatchScheduleView.AllAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem,
                        AllAndPackagingSpecification {
        }

}
