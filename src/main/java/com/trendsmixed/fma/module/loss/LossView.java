package com.trendsmixed.fma.module.loss;

import com.trendsmixed.fma.module.lossreason.LossReasonView;

/**
 *
 * @author Thilina
 */
public class LossView {

    public static interface Id {
    }

    public static interface Quantity {
    }

    public static interface LossReason extends LossReasonView.All {
    }

    public static interface Operation {
    }

    public static interface All extends Id, Quantity {
    }

    public static interface AllLossReasonAll extends Id, Quantity, LossReason {
    }

    public static interface AllLossReasonAllLossTypeAll extends AllLossReasonAll, LossReasonView.AllAndLossTypeAll {
    }

}
