package com.trendsmixed.fma.module.deliveryterm;

import com.trendsmixed.fma.utility.PageView;

public class DeliveryTermView {

    public interface Id {
    }

    public interface Name {
    }

    public interface Code {
    }

    public interface All extends Id, Name, Code, PageView.All {
    }

}
