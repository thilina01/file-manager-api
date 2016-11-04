package com.trendsmixed.fma.jsonView;

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
