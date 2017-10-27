package com.trendsmixed.fma.module.team;

import com.trendsmixed.fma.module.menu.MenuView;
import com.trendsmixed.fma.module.teammenu.TeamMenuView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class TeamView {

    public interface Id {
    }

    public interface Code {
    }

    public interface Name {
    }

    public interface TeamMenuList {
    }

    public interface User {
    }

    public interface All extends Id, Code, Name, PageView.All {
    }

    public interface AllAndMenuAll extends All, TeamMenuList, TeamMenuView.Menu, MenuView.All {
    }
}
