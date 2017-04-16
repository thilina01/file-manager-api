package com.trendsmixed.fma.dao;

import lombok.Data;

@Data
public class Combo {

	int id;
	String code;
	String name;
	String description;

	public Combo(int id, String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}

	public Combo(int id, String code, String name, String description) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
	}

}
