/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.team;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.teammenu.TeamMenu;
import com.trendsmixed.fma.module.user.User;
import com.trendsmixed.fma.module.team.TeamView;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "team")
@NamedQueries({
    @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t")})
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
    @JsonView(TeamView.TeamMenuList.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private List<TeamMenu> teamMenuList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private List<User> userList;

    public Team() {
    }

    public Team(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TeamMenu> getTeamMenuList() {
        return teamMenuList;
    }

    public void setTeamMenuList(List<TeamMenu> teamMenuList) {
        this.teamMenuList = teamMenuList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.Team[ id=" + id + " ]";
    }
    
}
