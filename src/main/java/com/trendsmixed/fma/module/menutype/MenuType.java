/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.menutype;

import com.trendsmixed.fma.module.menu.Menu;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.menutype.MenuTypeView;
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
import lombok.Data;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@Table(name = "menu_type")
@NamedQueries({
    @NamedQuery(name = "MenuType.findAll", query = "SELECT i FROM MenuType i")})
public class MenuType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(MenuTypeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(MenuTypeView.Code.class)
    @Column(name = "code")
    private String code;
    @JsonView(MenuTypeView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuType")
    private List<Menu> menuList;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuType)) {
            return false;
        }
        MenuType other = (MenuType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.MenuType[ id=" + id + " ]";
    }

}
