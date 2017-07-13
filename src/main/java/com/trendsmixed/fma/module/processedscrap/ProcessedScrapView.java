package com.trendsmixed.fma.module.processedscrap;

import com.trendsmixed.fma.module.lossreason.LossReasonView;
import com.trendsmixed.fma.module.section.SectionView;
import com.trendsmixed.fma.utility.PageView;

public class ProcessedScrapView {

    public static interface Id {
    }

    public static interface ProcessedDate {
    }

    public static interface SubItemCode {
    }

    public static interface Quantity {
    }

    public static interface UnitCost {
    }

    public static interface LossReason extends LossReasonView.All {
    }

    public static interface Section extends SectionView.All {
    }

    public static interface All extends Id, SubItemCode, ProcessedDate, Quantity, UnitCost, PageView.All {
    }

}
