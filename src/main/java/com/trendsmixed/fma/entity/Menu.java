package com.trendsmixed.fma.entity;

import lombok.Data;

@Data
public class Menu {
    String name;
    String target;

    public Menu(String name, String target) {
        this.name = name;
        this.target = target;
    }
    
}
