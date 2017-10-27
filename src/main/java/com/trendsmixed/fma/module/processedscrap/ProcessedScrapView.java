package com.trendsmixed.fma.module.processedscrap;

import com.trendsmixed.fma.module.lossreason.LossReasonView;
import com.trendsmixed.fma.module.section.SectionView;
import com.trendsmixed.fma.utility.PageView;

public class ProcessedScrapView {

    public interface Id {
    }

    public interface ProcessedDate {
    }

    public interface SubItemCode {
    }

    public interface Quantity {
    }

    public interface UnitCost {
    }

    public interface LossReason extends LossReasonView.All {
    }

    public interface Section extends SectionView.All {
    }

    public interface All extends Id, SubItemCode, ProcessedDate, Quantity, UnitCost, PageView.All {
    }

}
