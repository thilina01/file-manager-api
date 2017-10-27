package com.trendsmixed.fma.module.contacttype;

import com.trendsmixed.fma.module.contact.ContactView;
import com.trendsmixed.fma.utility.PageView;

public class ContactTypeView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface Contact {

    }

    public interface All extends Id, Code, Name, PageView.All {
    }

    public interface AllAndContactAll extends All, Contact, ContactView.All {
    }

}
