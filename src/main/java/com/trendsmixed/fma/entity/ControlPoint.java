package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.ControlPointView;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ControlPoint {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonView(ControlPointView.Code.class)
    String code;

    @JsonView(ControlPointView.Name.class)
    String name;

}
