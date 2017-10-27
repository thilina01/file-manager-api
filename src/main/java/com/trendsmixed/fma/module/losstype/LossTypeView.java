package com.trendsmixed.fma.module.losstype;

import com.trendsmixed.fma.module.lossreason.LossReasonView;
import com.trendsmixed.fma.utility.PageView;

public class LossTypeView {

    public interface Id {
    }

    public interface Name {
    }

    public interface Code {
    }

    public interface TypeInSinhala {
    }

    public interface LossReasonList {
    }

    public interface All extends Id, Name, Code, TypeInSinhala, PageView.All {
    }

    public interface AllAndLossReasonList extends All, LossReasonList, LossReasonView.All {
    }

}
