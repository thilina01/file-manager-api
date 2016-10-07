package com.trendsmixed.fma.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class DefectType {
	@Id
	@GeneratedValue
	private Integer id;
	
        String type;
        String name;
        String nameInShinhala;
        

}
