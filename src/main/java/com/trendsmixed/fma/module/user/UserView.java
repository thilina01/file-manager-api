package com.trendsmixed.fma.module.user;

import com.trendsmixed.fma.module.status.StatusView;
import com.trendsmixed.fma.module.team.TeamView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class UserView {

    public static interface Id {
    }

    public static interface Name {
    }

    public static interface Email {
    }

    public static interface Password {
    }

    public static interface Status {
    }

    public static interface Team {
    }

    public static interface All extends Id, Name, Email, Status, PageView.All {
    }

    public static interface AllAndTeamAll extends All, Team, TeamView.All {
    }

    public static interface AllAndTeamAllAndStatusAll extends AllAndTeamAll, Status, StatusView.All {
    }

    public static interface AllAndTeamAllAndMenuAll extends All, Team, TeamView.AllAndMenuAll {
    }
}
