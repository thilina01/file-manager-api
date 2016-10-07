package com.trendsmixed.fma.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class DownTime {

    @Id
    @GeneratedValue
    private Integer id;

    Date downTimeDate;
    int duretion;
    String reason;

}
