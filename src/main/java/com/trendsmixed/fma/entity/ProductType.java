package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.ProductTypeView;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ProductType {
	@Id
	@GeneratedValue
	private Integer id;
	
        @JsonView(ProductTypeView.Type.class)
        String type;
        
        @JsonView(ProductTypeView.Description.class)
        String description;

}
