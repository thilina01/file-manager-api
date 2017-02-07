package com.trendsmixed.fma.module.lossreason;

import com.trendsmixed.fma.module.losstype.LossTypeView;

public class LossReasonView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Reason {
    }

    public static interface ReasonInSinhala {
    }

    public static interface LossType {
    }

    public static interface All extends Id, Code, Reason, ReasonInSinhala {
    }

    public static interface AllAndLossTypeAll extends All, LossType, LossTypeView.All {
    }

}
