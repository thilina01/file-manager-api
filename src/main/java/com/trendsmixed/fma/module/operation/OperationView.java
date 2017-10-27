package com.trendsmixed.fma.module.operation;

import com.trendsmixed.fma.module.job.JobView;
import com.trendsmixed.fma.module.loss.LossView;
import com.trendsmixed.fma.module.operationtype.OperationTypeView;
import com.trendsmixed.fma.module.production.ProductionView;
import com.trendsmixed.fma.module.producttype.ProductTypeView;
import com.trendsmixed.fma.utility.PageView;

public class OperationView {

    public interface Id {
    }

    public interface PlannedQuantity {
    }

    public interface ActualQuantity {
    }

    public interface UnitWeight {
    }

    public interface Loss extends LossView.All {
    }

    public interface Production extends ProductionView.AllAndShiftAndShiftTypeAndControlPointAll {
    }

    public interface Job extends JobView.All {
    }

    public interface OperationType extends OperationTypeView.All {
    }

    public interface ProductType extends ProductTypeView.All {
    }

    public interface All extends Id, PlannedQuantity, ActualQuantity, UnitWeight, PageView.All {
    }

    public interface AllJobAllProductTypeAllOperationTypeAllLossAllLossReasonAllLossTypeAll
            extends All, Job, ProductType, OperationType, Loss, LossView.AllLossReasonAllLossTypeAll {
    }

    public interface AllJobAllProductionAllProductTypeAllOperationTypeAllLossAllLossReasonAllLossTypeAll
            extends AllJobAllProductTypeAllOperationTypeAllLossAllLossReasonAllLossTypeAll, Production {
    }

    public interface AllJobAllJobTypeAllItemAllProductionAllProductTypeAllOperationTypeAllLossAllLossReasonAllLossTypeAll
            extends AllJobAllProductionAllProductTypeAllOperationTypeAllLossAllLossReasonAllLossTypeAll, JobView.AllAndItemAllAndJobTypeAll {
    }
}
