package com.trendsmixed.fma.module.operationprogress;

import com.trendsmixed.fma.module.controlpoint.ControlPointView;
import com.trendsmixed.fma.module.costcenter.CostCenterView;
import com.trendsmixed.fma.module.operation.OperationView;
import com.trendsmixed.fma.module.operation.OperationView.Job;
import com.trendsmixed.fma.module.operation.OperationView.OperationType;
import com.trendsmixed.fma.module.operation.OperationView.ProductType;
import com.trendsmixed.fma.module.operation.OperationView.Production;
import com.trendsmixed.fma.module.production.ProductionView;
import com.trendsmixed.fma.module.production.ProductionView.ControlPoint;
import com.trendsmixed.fma.module.schedule.ScheduleView;
import com.trendsmixed.fma.module.workcenter.WorkCenterView;
import com.trendsmixed.fma.utility.PageView;

public class OperationProgressView {

    public interface Id {
    }

    public interface TimeSlot {
    }

    public interface Quantity {
    }

    public interface Operation extends OperationView.All {
    }

    public interface Schedule extends ScheduleView.All {
    }

    public interface AllAndProductionAll extends All, Production, ProductionView.All {
    }

    public interface AllAndControlPointAll extends All, ControlPoint, ProductionView.All {
    }

    public interface All extends Id, TimeSlot, Quantity, PageView.All {
    }

    public interface AllAndOperation extends All, Operation {
    }

    public interface AllAndProductionAndControlPoint extends All, ControlPoint, ProductionView.All {
    }

    public interface AllAndJobAndProductTypeAndProductionAndOperationType
            extends Job, ProductType, OperationType, OperationView.All {
    }

    public static interface AllAndControlPointAllWorkCenterCostCenterSection extends ControlPoint,
            ControlPointView.AllAndWorkCenterAll, WorkCenterView.AllAndCostCenterAll, CostCenterView.AllAndSectionAll {
    }

    public interface AllAndJobAndProductTypeAllAndProductionAndOperationTypeAndControlPointAllAndOperationAndAllAndControlPointAllWorkCenterCostCenterSection
            extends AllAndOperation, Job, ProductType, OperationType, OperationView.All, AllAndProductionAll,
            ControlPoint, ProductionView.All, ControlPointView.AllAndWorkCenterAll, WorkCenterView.AllAndCostCenterAll,
            CostCenterView.AllAndSectionAll {
    }
}
