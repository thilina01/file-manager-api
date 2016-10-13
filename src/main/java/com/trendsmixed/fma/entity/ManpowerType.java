package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.ManpowerTypeView;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ManpowerType {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonView(ManpowerTypeView.Type.class)
    String type;

}
