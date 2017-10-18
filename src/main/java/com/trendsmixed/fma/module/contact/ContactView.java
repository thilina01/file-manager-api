package com.trendsmixed.fma.module.contact;

import com.trendsmixed.fma.module.contacttype.ContactTypeView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class ContactView {

    public static interface Id {
    }

    public static interface ContactNumber {
    }

    public static interface Customer {
    }

    public static interface ContactType {
    }

    public static interface All extends Id, ContactNumber, PageView.All {
    }

    public static interface AllAndContactTypeAll extends All, ContactType, ContactTypeView.All {
    }

}
