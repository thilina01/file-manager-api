package com.trendsmixed.fma.module.user;

import com.trendsmixed.fma.module.status.StatusView;
import com.trendsmixed.fma.module.team.TeamView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class UserView {

    public interface Id {
    }

    public interface Name {
    }

    public interface Email {
    }

    public interface Password {
    }

    public interface Status {
    }

    public interface Team {
    }

    public interface All extends Id, Name, Email, Status, PageView.All {
    }

    public interface AllAndTeamAll extends All, Team, TeamView.All {
    }

    public interface AllAndTeamAllAndStatusAll extends AllAndTeamAll, Status, StatusView.All {
    }

    public interface AllAndTeamAllAndMenuAll extends All, Team, TeamView.AllAndMenuAll {
    }
}
