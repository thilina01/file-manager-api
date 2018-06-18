package com.trendsmixed.fma.module.supplier;

import com.trendsmixed.fma.module.currency.CurrencyView;
import com.trendsmixed.fma.module.deliveryterm.DeliveryTermView;
import com.trendsmixed.fma.module.paymentterm.PaymentTermView;
import com.trendsmixed.fma.module.suppliertype.SupplierTypeView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class SupplierView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface Fax {
    }

    public interface Email {
    }

    public interface ContactPerson {
    }

    public interface ShortName {
    }

    public interface Contact {
    }

    public interface Address {
    }

    public interface Currency {
    }

    public interface SupplierType {
    }

    public interface PaymentTerm {
    }

    public interface DeliveryTerm {
    }

    public interface All extends Id, Code, Name, Fax, Email, ContactPerson, ShortName, Contact, Address, PageView.All {
    }

    public interface AllAndCurrencyAll extends All, Currency, CurrencyView.All {
    }

    public interface AllAndPaymentTermAll extends All, PaymentTerm, PaymentTermView.All {
    }

    public interface AllAndDeliveryTermAll extends All, DeliveryTerm, DeliveryTermView.All {
    }

    public interface AllAndSupplierTypeAll extends All, SupplierType, SupplierTypeView.All {
    }

    public interface AllAndCurrencyAllAndSupplierTypeAllAndDeliveryTermAllAndPaymentTermAll extends All, Currency, CurrencyView.All, PaymentTerm, PaymentTermView.All, SupplierType, SupplierTypeView.All, DeliveryTerm, DeliveryTermView.All {
    }

}
