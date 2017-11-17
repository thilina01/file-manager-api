package com.trendsmixed.fma.module.invoicedispatchnote;

import com.trendsmixed.fma.module.dispatchnote.DispatchNoteView;

/**
 *
 * @author Daminda
 */
public class InvoiceDispatchNoteView {

    public interface Id {
    }

    public interface DispatchNote{
    }

    public interface Invoice {
    }

    public interface AllAndDispatchNoteAllAndDispatchAll extends Id, DispatchNote, DispatchNoteView.AllAndDispatchAll{
    }


}
