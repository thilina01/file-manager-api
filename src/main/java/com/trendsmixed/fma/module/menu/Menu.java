/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.menu;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.menutype.MenuType;
import com.trendsmixed.fma.module.teammenu.TeamMenu;
import com.trendsmixed.fma.module.usermenu.UserMenu;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @JsonView(MenuView.RouterLink.class)
    @Column(name = "router_link")
    private String routerLink;
    @JsonView(MenuView.Target.class)
    @Column(name = "target")
    private String target;
    @JsonView(MenuView.Href.class)
    @Column(name = "href")
    private String href;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "menu")
    private List<TeamMenu> teamMenuList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "menu")
    private List<UserMenu> userMenuList;
    @JsonView(MenuView.SubMenu.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "menu")
    private List<Menu> menuList;
    @JsonView(MenuView.SuperMenu.class)
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Menu menu;
    @JsonView(MenuView.MenuType.class)
    @JoinColumn(name = "menu_type_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private MenuType menuType;

    public Menu(Integer id) {
        this.id = id;
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

}
