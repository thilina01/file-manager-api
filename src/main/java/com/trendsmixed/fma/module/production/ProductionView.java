/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.production;

import com.trendsmixed.fma.module.controlpoint.ControlPointView;
import com.trendsmixed.fma.module.costcenter.CostCenterView;
import com.trendsmixed.fma.module.job.JobView;
import com.trendsmixed.fma.module.manpower.ManpowerView;
import com.trendsmixed.fma.module.operation.OperationView;
import com.trendsmixed.fma.module.shift.ShiftView;
import com.trendsmixed.fma.module.workcenter.WorkCenterView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Thilina
 */
public class ProductionView {

	public static interface Id {
	}

	public static interface ProductionDate {
	}

	public static interface PlannedDuration {
	}

	public static interface ActualDuration {
	}

	public static interface PlannedQuantity {
	}

	public static interface ActualQuantity {
	}

	public static interface ControlPoint {
	}

	public static interface Job {
	}

	public static interface Operation extends OperationView.All {
	}

	public static interface Manpower extends ManpowerView.AllManpowerTypeAll {
	}

	public static interface ProductType {
	}

	public static interface Shift {
	}

	public static interface All
			extends Id, ProductionDate, PlannedDuration, ActualDuration, PlannedQuantity, ActualQuantity, PageView.All {
	}

	public static interface AllAndShiftAll extends All, Shift, ShiftView.All {
	}

	public static interface AllAndShiftAllAndControlPointAll
			extends AllAndShiftAll, ControlPoint, ControlPointView.All {
	}

	public static interface AllAndShiftAllAndControlPointAllWorkCenterCostCenterSection
			extends AllAndShiftAll, ControlPoint, ControlPointView.AllAndWorkCenterAll,
			WorkCenterView.AllAndCostCenterAll, CostCenterView.AllAndSectionAll {
	}

	public static interface AllAndShiftAllAndControlPointAllManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAll
			extends AllAndShiftAllAndControlPointAll, Operation, Manpower,
			OperationView.AllJobAllProductTypeAllOperationTypeAllLossAllLossReasonAllLossTypeAll {
	}

	public static interface AllAndShiftAllAndControlPointAllWorkCenterCostCenterSectionManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAllItemAllJobTypeAll
			extends AllAndShiftAllAndControlPointAllWorkCenterCostCenterSection,
			AllAndShiftAllAndControlPointAllManpowerAllManpowerTypeAllOperationAllJobAllProductTypeAllOperationTypeAll,
			JobView.AllAndItemAllAndJobTypeAll {
	}

}
