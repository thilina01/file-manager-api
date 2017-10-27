package com.trendsmixed.fma.module.loss;

import com.trendsmixed.fma.module.lossreason.LossReasonView;

/**
 *
 * @author Thilina
 */
public class LossView {

    public interface Id {
    }

    public interface Quantity {
    }

    public interface LossReason extends LossReasonView.All {
    }

    public interface Operation {
    }

    public interface All extends Id, Quantity {
    }

    public interface AllLossReasonAll extends Id, Quantity, LossReason {
    }

    public interface AllLossReasonAllLossTypeAll extends AllLossReasonAll, LossReasonView.AllAndLossTypeAll {
    }

}
