package com.trendsmixed.fma.module.treatment;

import com.trendsmixed.fma.module.accident.AccidentView;
import com.trendsmixed.fma.module.treatmenttype.TreatmentTypeView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class TreatmentView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Description {
    }

    public static interface LossManHours {
    }

    public static interface StartTime {
    }

    public static interface EndTime {
    }

    public static interface TreatmentType {
    }

    public static interface Accident {
    }

    public static interface All extends Id, Code, Description, LossManHours, StartTime, EndTime, PageView.All {
    }

    public static interface AllAndTreatmentTypeAll extends All, TreatmentType, TreatmentTypeView.All {
    }

    public static interface AllAndAccidentAll extends All, Accident, AccidentView.All {
    }

}
