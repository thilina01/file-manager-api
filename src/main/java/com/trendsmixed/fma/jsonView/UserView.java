/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.jsonView;

/**
 *
 * @author Daminda
 */
public class UserView {

    public static interface Id {
    }

    public static interface Email {
    }

    public static interface Password {
    }

    public static interface Status {
    }

    public static interface Team {
    }

    public static interface All extends Id, Email, Status {
    }

    public static interface AllAndTeamAll extends All, Team, TeamView.All {
    }

    public static interface AllAndTeamAllAndMenuAll extends All, Team, TeamView.AllAndMenuAll {
    }
}
