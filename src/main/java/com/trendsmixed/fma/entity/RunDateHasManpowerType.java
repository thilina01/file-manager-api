package com.trendsmixed.fma.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class RunDateHasManpowerType {

    @Id
    @GeneratedValue
    private Integer id;

    int quantity;

}
