package com.trendsmixed.fma.module.team;

import com.trendsmixed.fma.module.menu.MenuView;
import com.trendsmixed.fma.module.teammenu.TeamMenuView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class TeamView {

    public static interface Id {
    }

    public static interface Code {
    }

    public static interface Name {
    }

    public static interface TeamMenuList {
    }

    public static interface User {
    }

    public static interface All extends Id, Code, Name, PageView.All {
    }

    public static interface AllAndMenuAll extends All, TeamMenuList, TeamMenuView.Menu, MenuView.All {
    }
}
