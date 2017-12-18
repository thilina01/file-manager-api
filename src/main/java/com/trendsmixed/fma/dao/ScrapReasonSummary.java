package com.trendsmixed.fma.dao;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.view.ScrapReasonSummaryView;
import com.trendsmixed.fma.module.lossreason.LossReason;

import java.util.Calendar;
import java.util.Date;
import lombok.Data;

@Data
public class ScrapReasonSummary {

    @JsonView(ScrapReasonSummaryView.LossReason.class)
    LossReason lossReason;
    @JsonView(ScrapReasonSummaryView.Category.class)
    String category;
    @JsonView(ScrapReasonSummaryView.Quantity.class)
    long quantity;
    @JsonView(ScrapReasonSummaryView.Value.class)
    double value;

    public ScrapReasonSummary(LossReason lossReason, Long quantity, Double value) {
        super();
        this.lossReason = lossReason ;//!= null ? lossReason : "NA";
        this.quantity = quantity != null ? quantity : 0;
        this.value = value != null ? value : 0.0;
    }

    public ScrapReasonSummary(Date date, Long quantity, Double value) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String category = (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.DAY_OF_MONTH) + "";
        this.category = category != null ? category : "NA";
        this.quantity = quantity != null ? quantity : 0;
        this.value = value != null ? value : 0.0;
    }

}
