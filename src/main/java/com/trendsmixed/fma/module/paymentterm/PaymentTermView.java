package com.trendsmixed.fma.module.paymentterm;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class PaymentTermView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface All extends Id, Code, Name, PageView.All {
    }

}
