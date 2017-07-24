package com.trendsmixed.fma.module.losstype;

import com.trendsmixed.fma.module.lossreason.LossReasonView;
import com.trendsmixed.fma.utility.PageView;

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

    public static interface All extends Id, Name, Code, TypeInSinhala, PageView.All {
    }

    public static interface AllAndLossReasonList extends All, LossReasonList, LossReasonView.All {
    }

}
