package com.trendsmixed.fma.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AppSession {
	@Id	
	String email;
        String lastIP;
        long lastTime;
        
}
