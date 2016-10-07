package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.CostCenterView;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CostCenter {
	@Id
	@GeneratedValue
	private Integer id;
        
	@JsonView(CostCenterView.Code.class)
        String code;
        
         @JsonView(CostCenterView.Name.class)
        String name;
       
        

}
