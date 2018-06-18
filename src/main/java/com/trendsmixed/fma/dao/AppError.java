package com.trendsmixed.fma.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppError {

    private long timestamp;
    private int status;
    private String error, exception,message,path;
}
