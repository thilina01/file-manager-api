package com.trendsmixed.fma.module.employee;

import com.trendsmixed.fma.module.designation.DesignationView;
import com.trendsmixed.fma.module.dispatchnote.DispatchNoteView;
import com.trendsmixed.fma.module.employeecategory.EmployeeCategoryView;
import com.trendsmixed.fma.module.labourtursource.LabourSourceView;
import com.trendsmixed.fma.module.section.SectionView;
import com.trendsmixed.fma.module.shift.ShiftView;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class EmployeeView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface FullName {
    }

    public static interface CallingName {
    }

    public static interface DateOfBirth {
    }

    public static interface ContactNumber {
    }

    public static interface FirstName {
    }

    public static interface LastName {
    }

    public static interface NIC {
    }

    public static interface All extends Id, Code, CallingName, FullName, LastName, FirstName, DateOfBirth, ContactNumber, NIC, PageView.All {
    }

    public static interface DispatchNote extends DispatchNoteView.All {
    }

    public static interface Designation extends DesignationView.All {
    }

    public static interface EmployeeCategory extends EmployeeCategoryView.All {
    }

    public static interface Shift extends ShiftView.All {
    }

    public static interface Section extends SectionView.All {
    }

    public static interface LabourSource extends LabourSourceView.All {
    }

    public static interface AllAndDesignationAllAndEmployeeCategoryAllAndShiftAllAndSectionAllAndLabourSourceAll extends All, Designation, DesignationView.All, EmployeeCategory, EmployeeCategoryView.All, Shift, ShiftView.All, Section, SectionView.All, LabourSource, LabourSourceView.All {
    }

}
