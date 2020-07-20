package com.trendsmixed.fma.dao.view;

import com.trendsmixed.fma.dao.view.CreditNoteItemRowView;

public class CreditNoteReportView {

    public interface DateOfCreditNote {
    }

    public interface CreditNoteNumber {
    }

    public interface InvoiceNumber {
    }

    public interface InvoiceTypeName {
    }

    public interface ExchangeRate {
    }

    public interface TaxRate {
    }

    public interface InvoiceTypeId {
    }

    public interface CustomerName {
    }

    public interface VatNo {
    }

    public interface SVatNo {
    }

    public interface Consignee {
    }

    public interface EmployeeName {
    }

    public interface PaymentTermName {
    }

    public interface IncotermName {
    }

    public interface CurrencyName {
    }

    public interface Id {
    }

    public interface CreditNoteItemRow extends CreditNoteItemRowView.All {
    }

    public interface All extends Id, DateOfCreditNote, CreditNoteNumber, InvoiceNumber, InvoiceTypeName, ExchangeRate,
            TaxRate, InvoiceTypeId, CustomerName, VatNo, SVatNo, Consignee, EmployeeName, PaymentTermName, IncotermName,
            CurrencyName, CreditNoteItemRow {
    }

}
