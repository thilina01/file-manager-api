package com.trendsmixed.fma.module.operation;

import com.trendsmixed.fma.module.job.JobView;
import com.trendsmixed.fma.module.operationtype.OperationTypeView;
import com.trendsmixed.fma.module.production.ProductionView;
import com.trendsmixed.fma.module.producttype.ProductTypeView;

public class OperationView {

	public static interface Id {
	}

	public static interface PlannedQuantity {
	}

	public static interface ActualQuantity {
	}

	public static interface UnitWeight {
	}

	public static interface Loss {
	}

	public static interface Production extends ProductionView.AllAndShiftAllAndControlPointAll {
	}

	public static interface Job extends JobView.All {
	}

	public static interface OperationType extends OperationTypeView.All {
	}

	public static interface ProductType extends ProductTypeView.All {
	}

	public static interface All extends Id, PlannedQuantity, ActualQuantity, UnitWeight {
	}

	public static interface AllJobAllProductionAllProductTypeAllOperationTypeAll
			extends All, Job, Production, ProductType, OperationType {
	}
}
