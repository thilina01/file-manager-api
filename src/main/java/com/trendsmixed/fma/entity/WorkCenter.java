package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.WorkCenterView;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class WorkCenter {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonView(WorkCenterView.Code.class)
    String code;

}
