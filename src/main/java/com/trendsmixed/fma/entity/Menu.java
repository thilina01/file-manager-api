/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.MenuView;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "menu")
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(MenuView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(MenuView.Name.class)
    @Column(name = "name")
    private String name;
    @JsonView(MenuView.Target.class)
    @Column(name = "target")
    private String target;
    @JsonView(MenuView.Href.class)
    @Column(name = "href")
    private String href;
    @JsonView(MenuView.Team.class)
    @JoinTable(name = "team_has_menu", joinColumns = {
        @JoinColumn(name = "menu_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "team_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Team> teamList;
    @JsonView(MenuView.SubMenu.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
    private List<Menu> menuList;
    @JsonView(MenuView.SuperMenu.class)
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Menu menu;

    public Menu() {
    }

    public Menu(String name, String target) {
        this.name = name;
        this.target = target;
    }

    public Menu(String name, String target, String href) {
        this.name = name;
        this.target = target;
        this.href = href;
    }

    public Menu(Integer id) {
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

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
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
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.Menu[ id=" + id + " ]";
    }

}
