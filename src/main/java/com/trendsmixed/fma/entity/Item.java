package com.trendsmixed.fma.entity;

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
	
        String code;
        String size;
        int weight;
        String volume;
        String productionToolAvalibility;
        String description;
        String drawingVersion;
        
        
        

}
