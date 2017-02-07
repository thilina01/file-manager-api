/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.menu;

import com.trendsmixed.fma.module.team.TeamView;

/**
 *
 * @author Daminda
 */
public class MenuView {

    public static interface Id {
    }

    public static interface Name {
    }

    public static interface Target {
    }

    public static interface Href {
    }

    public static interface TeamMenuList {
    }

    public static interface SuperMenu {
    }

    public static interface SubMenu {
    }

    public static interface All extends Id, Name, Target, Href {
    }

    public static interface AllAndTeamAll extends All, TeamMenuList, TeamView.All {
    }

    public static interface AllAndSubMenu extends All, SubMenu {
    }

    public static interface AllAndSuperMenu extends All, SuperMenu {
    }
}
