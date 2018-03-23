package com.trendsmixed.fma.module.contact;

import com.trendsmixed.fma.module.contacttype.ContactTypeView;
import com.trendsmixed.fma.module.employee.EmployeeView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class ContactView {

    public interface Id {
    }

    public interface ContactNumber {
    }

    public interface Customer {
    }

    public interface Employee {
    }

    public interface ContactType {
    }

    public interface All extends Id, ContactNumber, PageView.All {
    }

    public interface AllAndContactTypeAll extends All, ContactType, ContactTypeView.All {
    }

    public interface AllAndEmployeeAll extends All, Employee, EmployeeView.All {
    }

    public interface AllAndContactTypeAndEmployeeAll
            extends All, ContactType, ContactTypeView.All, Employee, EmployeeView.All {
    }

}
