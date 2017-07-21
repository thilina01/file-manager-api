package com.trendsmixed.fma.module.losstype;

import com.trendsmixed.fma.module.lossreason.LossReasonView;

public class LossTypeView {

    public static interface Id {
    }

    public static interface Name {
    }

    public static interface Code {
    }

    public static interface TypeInSinhala {
    }

    public static interface LossReasonList {
    }

    public static interface All extends Id, Name, Code, TypeInSinhala {
    }

    public static interface AlLAndLossReasonList extends All, LossReasonList, LossReasonView.All {
    }

}
