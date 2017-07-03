/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.shifttype.ShiftTypeView;
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
@Table(name = "shift_type")
@NamedQueries({
    @NamedQuery(name = "ShiftType.findAll", query = "SELECT i FROM ShiftType i")})
public class ShiftType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ShiftTypeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ShiftTypeView.Code.class)
    @Column(name = "code")
    private String code;
    @JsonView(ShiftTypeView.Name.class)
    @Column(name = "name")
    private String name;    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shiftType")
    private List<Production> productionList;
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShiftType)) {
            return false;
        }
        ShiftType other = (ShiftType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.ShiftType[ id=" + id + " ]";
    }
    
}
