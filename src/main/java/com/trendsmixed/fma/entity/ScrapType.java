package com.trendsmixed.fma.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ScrapType {
	@Id
	@GeneratedValue
	private Integer id;
	
        String code;
        String type;
        String typeInShinhala;
        

}
