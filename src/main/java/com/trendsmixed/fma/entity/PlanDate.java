package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.PlanDateView;
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
	
        @JsonView(PlanDateView.PlanDate.class)
        Date planDate;
        
        @JsonView(PlanDateView.Quantity.class)
        int quantity;
        
        @JsonView(PlanDateView.Shift.class)
        String shift;
        

}
