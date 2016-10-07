package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.PlanDateHasManpowerTypeView;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PlanDateHasManpowerType {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonView(PlanDateHasManpowerTypeView.Quantity.class)
    int quantity;

}
