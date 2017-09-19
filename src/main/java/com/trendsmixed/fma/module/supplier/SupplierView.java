/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.supplier;

import com.trendsmixed.fma.module.currency.CurrencyView;
import com.trendsmixed.fma.module.deliveryterm.DeliveryTermView;
import com.trendsmixed.fma.module.suppliertype.SupplierTypeView;
import com.trendsmixed.fma.module.paymentterm.PaymentTermView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class SupplierView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface Fax {
    }

    public static interface Email {
    }

    public static interface ContactPerson {
    }

    public static interface ShortName {
    }

    public static interface Contact {
    }

    public static interface Address {
    }

    public static interface Currency {
    }

    public static interface SupplierType {
    }

    public static interface PaymentTerm {
    }

    public static interface DeliveryTerm {
    }

    public static interface All extends Id, Code, Name, Fax, Email, ContactPerson, ShortName, Contact, Address, PageView.All {
    }

    public static interface AllAndCurrencyAll extends All, Currency, CurrencyView.All {
    }

    public static interface AllAndPaymentTermAll extends All, PaymentTerm, PaymentTermView.All {
    }

    public static interface AllAndDeliveryTermAll extends All, DeliveryTerm, DeliveryTermView.All {
    }

    public static interface AllAndSupplierTypeAll extends All, SupplierType, SupplierTypeView.All {
    }

    public static interface AllAndCurrencyAllAndSupplierTypeAllAndDeliveryTermAllAndPaymentTermAll extends All, Currency, CurrencyView.All,PaymentTerm, PaymentTermView.All, SupplierType, SupplierTypeView.All, DeliveryTerm, DeliveryTermView.All {
    }

}
