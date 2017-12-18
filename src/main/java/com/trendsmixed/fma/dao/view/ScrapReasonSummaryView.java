package com.trendsmixed.fma.dao.view;

import com.trendsmixed.fma.module.lossreason.LossReasonView;;

public class ScrapReasonSummaryView {

    public  interface LossReason extends LossReasonView.All {
    }

    public  interface Category {
    }
    
    public  interface Quantity {
    }

    public  interface Value {
    }

    public  interface All extends LossReason, Category, Quantity, Value {
    }

}
