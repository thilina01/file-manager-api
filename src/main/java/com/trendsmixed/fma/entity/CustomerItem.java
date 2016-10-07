package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.CustomerItemView;
import com.trendsmixed.fma.jsonView.CustomerView;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CustomerItem {
	@Id
	@GeneratedValue
	private Integer id;
	
        @JsonView(CustomerItemView.CustomerPartNo.class)
        String customerPartNo;
        
        @JsonView(CustomerItemView.Price.class)
        double price;
        
        

}
