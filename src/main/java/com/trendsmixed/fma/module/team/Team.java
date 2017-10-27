package com.trendsmixed.fma.module.team;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.teammenu.TeamMenu;
import com.trendsmixed.fma.module.user.User;
import java.io.Serializable;
import java.util.List;
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
@Table(name = "team")
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(TeamView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(TeamView.Name.class)
    @Column(name = "name")
    private String name;
    @JsonView(TeamView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(TeamView.TeamMenuList.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "team")
    private List<TeamMenu> teamMenuList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "team")
    private List<User> userList;

}
