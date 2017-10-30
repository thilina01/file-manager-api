package com.trendsmixed.fma.module.production;

import com.trendsmixed.fma.module.controlpoint.ControlPointView;
import com.trendsmixed.fma.module.costcenter.CostCenterView;
import com.trendsmixed.fma.module.job.JobView;
import com.trendsmixed.fma.module.manpower.ManpowerView;
import com.trendsmixed.fma.module.operation.OperationView;
import com.trendsmixed.fma.module.productionemployee.ProductionEmployeeView;
import com.trendsmixed.fma.module.shift.ShiftView;
import com.trendsmixed.fma.module.shifttype.ShiftTypeView;
import com.trendsmixed.fma.module.workcenter.WorkCenterView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Thilina
 */
public class ProductionView {

    public interface Id {
    }

    public interface ProductionDate {
    }

    public interface PlannedDuration {
    }

    public interface ActualDuration {
    }

    public interface PlannedQuantity {
    }

    public interface ActualQuantity {
    }

    public interface ControlPoint {
    }

    public interface Job {
    }

    public interface Operation extends OperationView.All {
    }

    public interface Manpower extends ManpowerView.AllManpowerTypeAll {
    }

    public interface ProductType {
    }

    public interface Shift {
    }

    public interface ShiftType {
    }

    public interface ProductionEmployee extends ProductionEmployeeView.All {
    }

    public interface All
            extends Id, ProductionDate, PlannedDuration, ActualDuration, PlannedQuantity, ActualQuantity, PageView.All {
    }

    public static interface AllAndShiftAndShiftType extends All, Shift, ShiftView.All, ShiftType, ShiftTypeView.All {
    }

    public static interface AllAndShiftAndShiftTypeAndControlPointAll
            extends AllAndShiftAndShiftType, ControlPoint, ControlPointView.All {
    }

    public static interface AllAndShiftAllAndControlPointAllWorkCenterCostCenterSection
            extends AllAndShiftAndShiftType, ControlPoint, ControlPointView.AllAndWorkCenterAll,
            WorkCenterView.AllAndCostCenterAll, CostCenterView.AllAndSectionAll {
    }

    public static interface AllAndShiftAllAndControlPointAllManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAll
            extends AllAndShiftAndShiftTypeAndControlPointAll, Operation, Manpower,
            OperationView.AllJobAllProductTypeAllOperationTypeAllLossAllLossReasonAllLossTypeAll {
    }

    public static interface AllAndShiftAllAndControlPointAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll
            extends AllAndShiftAllAndControlPointAllWorkCenterCostCenterSection,
            AllAndShiftAllAndControlPointAllManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAll,
            JobView.AllAndItemAllAndJobTypeAll {
    }
    public static interface AllAndShiftAllAndControlPointAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAllProductionEmployeeAllAndEmployeeAll
            extends AllAndShiftAllAndControlPointAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll, ProductionEmployee, ProductionEmployeeView.AllAndEmployeeAll{
    }

}
