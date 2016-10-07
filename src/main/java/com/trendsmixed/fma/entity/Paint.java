package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.PaintView;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Paint {
	@Id
	@GeneratedValue
	private Integer id;
	
        @JsonView(PaintView.Code.class)
        String code;
        
        @JsonView(PaintView.Description.class)
        String description;

}
