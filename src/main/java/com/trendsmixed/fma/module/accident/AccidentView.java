/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface ReferenceNo {
    }

    public static interface RootCause {
    }

    public static interface CorrectiveAction {
    }

    public static interface ResponsiblePerson {
    }

    public static interface AccidentDate {
    }

    public static interface AccidentType {
    }

    public static interface Treatment {
    }

    public static interface Employee {
    }

    public static interface Machine {
    }

    public static interface Section {
    }

    public static interface Shift {
    }

    public static interface All extends Id, Code, ReferenceNo, RootCause, CorrectiveAction, ResponsiblePerson, AccidentDate, PageView.All {
    }

    public static interface AllAndAccidentTypeAll extends All, AccidentType, AccidentTypeView.All {
    }

    public static interface AllAndEmployeeAll extends All, Employee, EmployeeView.All {
    }

    public static interface AllAndMachineAll extends All, Machine, MachineView.All {
    }

    public static interface AllAndSectionAll extends All, Section, SectionView.All {
    }

    public static interface AllAndShiftAll extends All, Shift, ShiftView.All {
    }

    public static interface AllAndTreatmentAll extends All, Treatment, TreatmentView.All {
    }

    public static interface AllAndTreatmentTypeAll extends All, TreatmentType, TreatmentTypeView.All {
    }

    public static interface AllAndAccidentTypeAllAndEmployeeAllAndMachineAllAndSectionAllAndShiftAllAndTreatmentAllAndTreatmentTypeAll extends All, AccidentType, AccidentTypeView.All, Employee, EmployeeView.All, Machine, MachineView.All, Section, SectionView.All, Shift, ShiftView.All, Treatment, TreatmentView.All, TreatmentType, TreatmentTypeView.All {
    }

}
