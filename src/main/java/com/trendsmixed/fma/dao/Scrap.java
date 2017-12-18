package com.trendsmixed.fma.dao;

import java.util.Calendar;
import java.util.Date;
import lombok.Data;

@Data
public class Scrap {

    String category;
    long quantity;
    double value;

    public Scrap(String category, Long quantity, Double value) {
        super();
        this.category = category != null ? category : "NA";
        this.quantity = quantity != null ? quantity : 0;
        this.value = value != null ? value : 0.0;
    }

    public Scrap(Date date, Long quantity, Double value) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String category = (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.DAY_OF_MONTH) + "";
        this.category = category != null ? category : "NA";
        this.quantity = quantity != null ? quantity : 0;
        this.value = value != null ? value : 0.0;
    }

}
