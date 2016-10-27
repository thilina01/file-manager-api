/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.ManpowerTypeView;
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
@Table(name = "manpower_type")
@NamedQueries({
    @NamedQuery(name = "ManpowerType.findAll", query = "SELECT m FROM ManpowerType m")})
public class ManpowerType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ManpowerTypeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ManpowerTypeView.Type.class)
    @Column(name = "type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manpowerType")
    private List<PlanDateManpower> planDateManpowerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manpowerType")
    private List<RunDateManpower> runDateManpowerList;

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

    public List<PlanDateManpower> getPlanDateManpowerList() {
        return planDateManpowerList;
    }

    public void setPlanDateManpowerList(List<PlanDateManpower> planDateManpowerList) {
        this.planDateManpowerList = planDateManpowerList;
    }

    public List<RunDateManpower> getRunDateManpowerList() {
        return runDateManpowerList;
    }

    public void setRunDateManpowerList(List<RunDateManpower> runDateManpowerList) {
        this.runDateManpowerList = runDateManpowerList;
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
