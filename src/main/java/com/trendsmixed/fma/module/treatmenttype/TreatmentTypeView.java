package com.trendsmixed.fma.module.treatmenttype;

import com.trendsmixed.fma.module.treatment.TreatmentView;
import com.trendsmixed.fma.utility.PageView;

public class TreatmentTypeView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface All extends Id, Code, Name, PageView.All {
    }

    public interface Treatment extends TreatmentView.All {
    }

}
