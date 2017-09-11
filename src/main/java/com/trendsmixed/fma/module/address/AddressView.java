/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.address;

import com.trendsmixed.fma.module.addresstype.AddressTypeView;
import com.trendsmixed.fma.module.country.CountryView;
import com.trendsmixed.fma.module.dispatchnote.DispatchNoteView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class AddressView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface Line1 {
    }

    public static interface Line2 {
    }

    public static interface Line3 {
    }

    public static interface Line4 {
    }

    public static interface Line5 {
    }
    
    public static interface AddressType {
    }
    
     public static interface Country {
    }
    
    public static interface Customer {
    }
    
    public static interface All extends Id, Code, Name, Line1, Line2, Line3, Line4, Line5, PageView.All {
    }

    public static interface AllAndAddressTypeAll extends All, AddressType, AddressTypeView.All{
    }

    public static interface AllAndAddressTypeAllAndCountryAll extends AllAndAddressTypeAll, Country, CountryView.All{
    }
    
    public static interface DispatchNote extends DispatchNoteView.All {
    }
   

 
   
}
