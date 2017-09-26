package com.trendsmixed.fma.module.treatmenttype;

import com.trendsmixed.fma.module.treatment.TreatmentView;
import com.trendsmixed.fma.utility.PageView;

public class TreatmentTypeView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface All extends Id, Code, Name, PageView.All {
    }

    public static interface Treatment extends TreatmentView.All {
    }

}
