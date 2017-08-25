package com.trendsmixed.fma.module.lossreason;

import com.trendsmixed.fma.module.losstype.LossTypeView;
import com.trendsmixed.fma.utility.PageView;

public class LossReasonView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface ReasonInSinhala {
    }

    public static interface LossType extends LossTypeView.All{
    }

    public static interface All extends Id, Code, Name, ReasonInSinhala, PageView.All {
    }

    public static interface AllAndLossTypeAll extends All, LossType  {
    }

}
