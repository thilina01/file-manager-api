package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.MachineView;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Machine {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonView(MachineView.Code.class)
    String code;

    @JsonView(MachineView.Name.class)
    String name;

    @JsonView(MachineView.EnergyRate.class)
    double energyRate;

}
