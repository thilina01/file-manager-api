package com.trendsmixed.fma.module.losstype;

import com.trendsmixed.fma.module.lossreason.LossReasonView;

public class LossTypeView {

    public static interface Id {
    }

    public static interface Type {
    }

    public static interface Code {
    }

    public static interface TypeInSinhala {
    }

    public static interface LossReasonList {
    }

    public static interface All extends Id, Type, Code, TypeInSinhala {
    }

    public static interface AlLAndLossReasonList extends All, LossReasonList, LossReasonView.All {
    }

}
