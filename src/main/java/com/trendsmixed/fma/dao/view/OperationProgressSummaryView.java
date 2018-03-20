package com.trendsmixed.fma.dao.view;

import com.trendsmixed.fma.module.controlpoint.ControlPointView;
import com.trendsmixed.fma.module.job.JobView;
import com.trendsmixed.fma.module.operation.OperationView;
import com.trendsmixed.fma.module.operationtype.OperationTypeView;
import com.trendsmixed.fma.module.production.ProductionView;
import com.trendsmixed.fma.module.section.SectionView;

public class OperationProgressSummaryView {

    public interface ControlPoint extends ControlPointView.All {
    }

    public interface Section extends SectionView.All{
    }

    public interface Production extends ProductionView.AllAndOperationAndOperationProgressAndJobAndItem{
    }

    public interface All extends  ControlPoint, Section, Production, OperationView.Job, JobView.AllAndItemAll, OperationView.OperationType, OperationTypeView.All  {
    }

}
