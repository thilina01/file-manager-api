/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.employee;

import com.trendsmixed.fma.module.dispatchnote.DispatchNoteView;
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

    public static interface FirstName {
    }

    public static interface LastName {
    }

    public static interface DateOfBirth {
    }

    public static interface ContactNumber {
    }

    public static interface Address {
    }

    public static interface NIC {
    }

    public static interface All extends Id, Code, FirstName, LastName, DateOfBirth, ContactNumber, Address, NIC, PageView.All {
    }
    public static interface DispatchNote extends DispatchNoteView.All {
    }

}
