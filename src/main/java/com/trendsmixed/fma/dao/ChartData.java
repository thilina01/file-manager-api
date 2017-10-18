package com.trendsmixed.fma.dao;

import java.util.ArrayList;

@lombok.Data
public class ChartData {

    String hTitle, vTitle;
    ArrayList dataArray;
    ArrayList<Column> columns;
    ArrayList rows;

    public ChartData(String hTitle, String vTitle, ArrayList dataArray) {
        this.hTitle = hTitle;
        this.vTitle = vTitle;
        this.dataArray = dataArray;
    }

    public ChartData(String hTitle, String vTitle, ArrayList<Column> columns, ArrayList rows) {
        this.hTitle = hTitle;
        this.vTitle = vTitle;
        this.columns = columns;
        this.rows = rows;
    }

}
