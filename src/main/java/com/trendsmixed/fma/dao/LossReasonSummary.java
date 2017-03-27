package com.trendsmixed.fma.dao;

import lombok.Data;

@Data
public class LossReasonSummary {
	String id;
	String code;
	String name;
	long total;

	public LossReasonSummary(Integer id, String code, String name, Long total) {
		super();
		this.id = id != null ? id+"" : "0";
		this.code = code != null ? code : "NA";
		this.name = name != null ? name : "NA";
		this.total = total != null ? total : 0;
	}

}