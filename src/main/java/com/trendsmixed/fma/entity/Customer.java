package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.CostCenterView;
import com.trendsmixed.fma.jsonView.CustomerView;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonView(CustomerView.Code.class)
    String code;

    @JsonView(CustomerView.Name.class)
    String name;

    @JsonView(CustomerView.Code.class)
    String currency;

}
