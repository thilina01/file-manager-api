package com.trendsmixed.fma.module.scrap;

import com.trendsmixed.fma.module.defect.DefectView;
import com.trendsmixed.fma.module.itemtype.ItemTypeView;
import com.trendsmixed.fma.module.job.JobView;
import com.trendsmixed.fma.module.lossreason.LossReasonView;
import com.trendsmixed.fma.module.operation.OperationView;
import com.trendsmixed.fma.module.operationtype.OperationTypeView;
import com.trendsmixed.fma.module.section.SectionView;
import com.trendsmixed.fma.utility.PageView;

public class ScrapView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface ScrapDate {
    }

    public interface Quantity {
    }

    public interface UnitValue {
    }

    public interface Job extends JobView.All {
    }

    public static interface Section extends SectionView.All {
    }

    public static interface Operation extends OperationView.All {
    }

    public static interface OperationType extends OperationTypeView.All {
    }

    public static interface ItemType extends ItemTypeView.All {
    }

    public static interface LossReason extends LossReasonView.All {
    }

    public static interface All extends Id, Code, Name, ScrapDate, Quantity, UnitValue, PageView.All {
    }

    public static interface AllAndSectionAll extends All, Section {
    }

    public static interface AllAndOperationAll extends All, Operation {
    }

    public static interface AllAndOperationTypeAll extends All, OperationType {
    }

    public static interface AllAndJobAll extends All, Job {
    }

    public static interface AllAndLossReasonAll extends All, LossReason {
    }

    public static interface AllAndItemTypeIAll extends All, ItemType {
    }

    public static interface AllAndItemTypeAllAndLossReasonAllAndOperationTypeAllAndSectionAllAndJobAll extends
            All, ItemType, LossReason, OperationType, Section, Job {
    }

}
