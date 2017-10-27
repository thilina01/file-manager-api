package com.trendsmixed.fma.module.treatment;

import com.trendsmixed.fma.module.accident.AccidentView;
import com.trendsmixed.fma.module.treatmenttype.TreatmentTypeView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class TreatmentView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Description {
    }

    public interface LossManHours {
    }

    public interface StartTime {
    }

    public interface EndTime {
    }

    public interface TreatmentType {
    }

    public interface Accident {
    }

    public interface All extends Id, Code, Description, LossManHours, StartTime, EndTime, PageView.All {
    }

    public interface AllAndTreatmentTypeAll extends All, TreatmentType, TreatmentTypeView.All {
    }

    public interface AllAndAccidentAll extends All, Accident, AccidentView.All {
    }

}
