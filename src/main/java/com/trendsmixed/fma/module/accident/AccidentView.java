package com.trendsmixed.fma.module.accident;

import com.trendsmixed.fma.module.accidenttype.AccidentTypeView;
import com.trendsmixed.fma.module.employee.EmployeeView;
import com.trendsmixed.fma.module.machine.MachineView;
import com.trendsmixed.fma.module.section.SectionView;
import com.trendsmixed.fma.module.shift.ShiftView;
import com.trendsmixed.fma.module.treatment.TreatmentView;
import com.trendsmixed.fma.module.treatment.TreatmentView.TreatmentType;
import com.trendsmixed.fma.module.treatmenttype.TreatmentTypeView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class AccidentView {

    public interface Id {
    }

    public interface Code {
    }

    public interface ReferenceNo {
    }

    public interface RootCause {
    }

    public interface CorrectiveAction {
    }

    public interface AccidentDate {
    }

    public interface AccidentType {
    }

    public interface Treatment {
    }

    public interface Employee {
    }

    public interface Machine {
    }

    public interface Section {
    }

    public interface Shift {
    }

    public interface ResponsiblePerson {
    }

    public interface All extends Id, Code, ReferenceNo, RootCause, CorrectiveAction, AccidentDate, PageView.All {
    }

    public interface AllAndAccidentTypeAll extends All, AccidentType, AccidentTypeView.All {
    }

    public interface AllAndEmployeeAll extends All, Employee, EmployeeView.All {
    }

    public interface AllAndResponsiblePersonAll extends All, ResponsiblePerson, EmployeeView.All {
    }

    public interface AllAndMachineAll extends All, Machine, MachineView.All {
    }

    public interface AllAndSectionAll extends All, Section, SectionView.All {
    }

    public interface AllAndShiftAll extends All, Shift, ShiftView.All {
    }

    public interface AllAndTreatmentAll extends All, Treatment, TreatmentView.All {
    }

    public interface AllAndTreatmentTypeAll extends All, TreatmentType, TreatmentTypeView.All {
    }

    public interface AllAndAccidentTypeAllAndResponsiblePersonAndEmployeeAllAndMachineAllAndSectionAllAndShiftAllAndTreatmentAllAndTreatmentTypeAll extends All, AccidentType, AccidentTypeView.All, Employee, EmployeeView.All, ResponsiblePerson, Machine, MachineView.All, Section, SectionView.All, Shift, ShiftView.All, Treatment, TreatmentView.All, TreatmentType, TreatmentTypeView.All {
    }

}
