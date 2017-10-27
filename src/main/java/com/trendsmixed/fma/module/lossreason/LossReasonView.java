package com.trendsmixed.fma.module.lossreason;

import com.trendsmixed.fma.module.losstype.LossTypeView;
import com.trendsmixed.fma.utility.PageView;

public class LossReasonView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface ReasonInSinhala {
    }

    public interface LossType extends LossTypeView.All {
    }

    public interface All extends Id, Code, Name, ReasonInSinhala, PageView.All {
    }

    public interface AllAndLossTypeAll extends All, LossType {
    }

}
