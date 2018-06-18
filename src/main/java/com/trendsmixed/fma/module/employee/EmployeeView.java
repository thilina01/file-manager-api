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

    public interface Id {
    }

    public interface Code {
    }

    public interface FullName {
    }

    public interface CallingName {
    }

    public interface DateOfBirth {
    }

    public interface ContactNumber {
    }

    public interface FirstName {
    }

    public interface LastName {
    }

    public interface NIC {
    }

    public interface ProductionEmployee {
    }

    public interface All extends Id, Code, CallingName, FullName, LastName, FirstName, DateOfBirth, ContactNumber, NIC, PageView.All {
    }

    public interface DispatchNote extends DispatchNoteView.All {
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
