package com.trendsmixed.fma.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class RunDate {

    @Id
    @GeneratedValue
    private Integer id;

    Date runDate;
    int duration;
    int quantity;
    int scrap;
    int rework;
    String shift;

}
