package com.trendsmixed.fma.module.user;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.status.Status;
import com.trendsmixed.fma.module.team.Team;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "user", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"email"}, name = "UK_USER_EMAIL")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(UserView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(UserView.Email.class)
    @Column(name = "email")
    private String email;
    @JsonView(UserView.Name.class)
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @JsonView(UserView.Status.class)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Status status;
    @JsonView(UserView.Team.class)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Team team;

    public User(Integer id) {
        this.id = id;
    }

    @JsonView(UserView.All.class)
    public String getDisplay() {
        return name;
    }
}
