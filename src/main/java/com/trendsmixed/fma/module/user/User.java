/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.user;

import com.trendsmixed.fma.module.team.Team;
import com.trendsmixed.fma.module.status.Status;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(UserView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(UserView.Email.class)
    @Column(name = "email",unique=true)
    private String email;
    @JsonView(UserView.Name.class)
    @Column(name = "name")
    private String name;
    //@JsonView(UserView.Password.class)
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

}
