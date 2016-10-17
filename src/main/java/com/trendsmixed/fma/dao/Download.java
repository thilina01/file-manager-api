package com.trendsmixed.fma.dao;

import lombok.Data;

@Data
public class Download {

    String name = "Not Found";
    String extension = "N/A";
    byte[] bytes = new byte[0];
}
