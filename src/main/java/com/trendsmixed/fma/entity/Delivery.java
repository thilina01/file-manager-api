package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.DeliveryView;
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

    @JsonView(DeliveryView.DeliverdQuantity.class)
    double deliverdQuantity;

    @JsonView(DeliveryView.DeliveryDate.class)
    Date deliveryDate;

    @JsonView(DeliveryView.Location.class)
    String locaton;

}
