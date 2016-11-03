/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.ControlPointRunManpowerView;
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

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "control_point_run_manpower")
@NamedQueries({
    @NamedQuery(name = "ControlPointRunManpower.findAll", query = "SELECT c FROM ControlPointRunManpower c")})
public class ControlPointRunManpower implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ControlPointRunManpowerView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ControlPointRunManpowerView.Count.class)
    @Column(name = "count")
    private Integer count;
    @JsonView(ControlPointRunManpowerView.ControlPointRun.class)
    @JoinColumn(name = "control_point_run_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ControlPointRun controlPointRun;
    @JsonView(ControlPointRunManpowerView.ManpowerType.class)
    @JoinColumn(name = "manpower_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ManpowerType manpowerType;

    public ControlPointRunManpower() {
    }

    public ControlPointRunManpower(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ControlPointRun getControlPointRun() {
        return controlPointRun;
    }

    public void setControlPointRun(ControlPointRun controlPointRun) {
        this.controlPointRun = controlPointRun;
    }

    public ManpowerType getManpowerType() {
        return manpowerType;
    }

    public void setManpowerType(ManpowerType manpowerType) {
        this.manpowerType = manpowerType;
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
        if (!(object instanceof ControlPointRunManpower)) {
            return false;
        }
        ControlPointRunManpower other = (ControlPointRunManpower) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.ControlPointRunManpower[ id=" + id + " ]";
    }

}
