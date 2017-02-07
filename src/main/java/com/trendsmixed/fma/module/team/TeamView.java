/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.team;

import com.trendsmixed.fma.module.menu.MenuView;
import com.trendsmixed.fma.module.teammenu.TeamMenuView;

/**
 *
 * @author Daminda
 */
public class TeamView {

    public static interface Id {
    }

    public static interface Name {
    }

    public static interface TeamMenuList {
    }

    public static interface User {
    }

    public static interface All extends Id, Name {
    }

    public static interface AllAndMenuAll extends All, TeamMenuList, TeamMenuView.Menu, MenuView.All {
    }
}
