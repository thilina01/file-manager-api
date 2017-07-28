package com.trendsmixed.fma.module.teammenu;

import com.trendsmixed.fma.module.menu.Menu;
import com.trendsmixed.fma.module.team.Team;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeamMenuRepository extends JpaRepository<TeamMenu, Integer> {

    @Query(value = "select teamMenu.menu from TeamMenu teamMenu where teamMenu.team= :team And teamMenu.menu.menu IS NULL ")
    public List<Menu> findTopMenuByTeam(@Param("team") Team team);

    public TeamMenu findByTeamAndMenu(Team team, Menu menu);

    public List<TeamMenu> findByTeam(Team team);

}
