package com.trendsmixed.fma.module.menu;

import com.trendsmixed.fma.module.team.TeamView;

/**
 *
 * @author Daminda
 */
public class MenuView {

    public interface Id {
    }

    public interface Name {
    }

    public interface RouterLink {
    }

    public interface Target {
    }

    public interface Href {
    }

    public interface TeamMenuList {
    }

    public interface SuperMenu {
    }

    public interface SubMenu {
    }

    public interface MenuType {
    }

    public interface All extends Id, Name, RouterLink, Target, Href {
    }

    public interface AllAndTeamAll extends All, TeamMenuList, TeamView.All {
    }

    public interface AllAndSubMenu extends All, SubMenu {
    }

    public interface AllAndSuperMenu extends All, SuperMenu {
    }
}
