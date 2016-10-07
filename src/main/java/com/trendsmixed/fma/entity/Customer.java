package com.trendsmixed.fma.entity;

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
	
        String code;
        String name;
        String currency;
        

}
