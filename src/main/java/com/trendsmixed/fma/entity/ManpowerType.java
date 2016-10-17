/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "manpower_type")
@NamedQueries({
    @NamedQuery(name = "ManpowerType.findAll", query = "SELECT m FROM ManpowerType m")})
public class ManpowerType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manpowerType")
    private Collection<RunDateHasManpowerType> runDateHasManpowerTypeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manpowerType")
    private Collection<PlanDateHasManpowerType> planDateHasManpowerTypeCollection;

    public ManpowerType() {
    }

    public ManpowerType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<RunDateHasManpowerType> getRunDateHasManpowerTypeCollection() {
        return runDateHasManpowerTypeCollection;
    }

    public void setRunDateHasManpowerTypeCollection(Collection<RunDateHasManpowerType> runDateHasManpowerTypeCollection) {
        this.runDateHasManpowerTypeCollection = runDateHasManpowerTypeCollection;
    }

    public Collection<PlanDateHasManpowerType> getPlanDateHasManpowerTypeCollection() {
        return planDateHasManpowerTypeCollection;
    }

    public void setPlanDateHasManpowerTypeCollection(Collection<PlanDateHasManpowerType> planDateHasManpowerTypeCollection) {
        this.planDateHasManpowerTypeCollection = planDateHasManpowerTypeCollection;
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
        if (!(object instanceof ManpowerType)) {
            return false;
        }
        ManpowerType other = (ManpowerType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.ManpowerType[ id=" + id + " ]";
    }
    
}
