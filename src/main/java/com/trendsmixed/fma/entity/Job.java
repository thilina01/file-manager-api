package com.trendsmixed.fma.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Job {
	@Id
	@GeneratedValue
	private Integer id;
	
        String jobNo;
        Date actualSippedDate;
        Date confirmShippedDate;
        double jobQuantity;
        Date jobDate;
        String comment;
        

}
