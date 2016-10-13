package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.ItemView;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonView(ItemView.Code.class)
    String code;

    @JsonView(ItemView.Size.class)
    String size;

    @JsonView(ItemView.Weight.class)
    int weight;

    @JsonView(ItemView.Volume.class)
    String volume;

    @JsonView(ItemView.ProductionToolAvalibility.class)
    String productionToolAvalibility;

    @JsonView(ItemView.Description.class)
    String description;

    @JsonView(ItemView.DrawingVersion.class)
    String drawingVersion;

}
