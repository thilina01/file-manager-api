package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.ItemHasMachineView;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ItemHasMachine {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonView(ItemHasMachineView.ConsumptionRate.class)
    double consumptionRate;

}
