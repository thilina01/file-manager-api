package com.trendsmixed.fma.dao;

import lombok.Data;

@Data
public class Column {

    String type, name;

    public Column(String type, String name) {
        this.type = type;
        this.name = name;
    }


}
