package com.trendsmixed.fma.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PlanDate {
	@Id
	@GeneratedValue
	private Integer id;
	
        Date planDate;
        int quantity;
        String shift;
        

}
