package com.trendsmixed.fma.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Delivery {

    @Id
    @GeneratedValue
    private Integer id;

    double deliverdQuantity;
    Date deliveryDate;
    String locaton;

}
