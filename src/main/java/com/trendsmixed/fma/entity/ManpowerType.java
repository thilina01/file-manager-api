/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "manpowerType")
    private PlanDateManpower planDateManpower;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "manpowerType")
    private RunDateManpower runDateManpower;

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

    public PlanDateManpower getPlanDateManpower() {
        return planDateManpower;
    }

    public void setPlanDateManpower(PlanDateManpower planDateManpower) {
        this.planDateManpower = planDateManpower;
    }

    public RunDateManpower getRunDateManpower() {
        return runDateManpower;
    }

    public void setRunDateManpower(RunDateManpower runDateManpower) {
        this.runDateManpower = runDateManpower;
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
