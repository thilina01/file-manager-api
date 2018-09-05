package com.trendsmixed.fma.module.debitnote;

import com.trendsmixed.fma.module.invoice.InvoiceView;
import com.trendsmixed.fma.module.invoicetype.InvoiceTypeView;
import com.trendsmixed.fma.utility.PageView;

public class DebitNoteView {

    public interface Id {
    }

    public interface Invoice {
    }

    public interface InvoiceType {
    }

    public interface DateOfDebitNote {
    }

    public interface DebitNoteNumber {
    }

    public interface All extends Id, DateOfDebitNote, DebitNoteNumber, PageView.All {
    }

    public interface AllAndInvoice extends All, Invoice, InvoiceView.All {
    }

    public interface AllAndInvoiceType extends All, InvoiceType, InvoiceTypeView.All {
    }

}
