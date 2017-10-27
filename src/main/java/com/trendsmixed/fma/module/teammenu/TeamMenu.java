package com.trendsmixed.fma.module.teammenu;

import com.trendsmixed.fma.module.team.Team;
import com.trendsmixed.fma.module.menu.Menu;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "team_menu", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"team_id", "menu_id"})})
public class TeamMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(TeamMenuView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(TeamMenuView.Menu.class)
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Menu menu;
    @JsonView(TeamMenuView.Team.class)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Team team;

}
