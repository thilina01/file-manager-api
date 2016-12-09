package com.trendsmixed.fma.dao;

import java.util.ArrayList;
import lombok.Data;

@Data
public class Menu {

    String name = "";
    String target = "";
    String href = "";
    ArrayList<Menu> menus = new ArrayList<>();

    public Menu(String name, String target) {
        this.name = name;
        this.target = target;
    }

    public Menu(String name, String target, String href) {
        this.name = name;
        this.target = target;
        this.href = href;
    }

}
