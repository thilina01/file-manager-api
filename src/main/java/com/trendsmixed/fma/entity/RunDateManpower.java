/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "run_date_manpower")
@NamedQueries({
    @NamedQuery(name = "RunDateManpower.findAll", query = "SELECT r FROM RunDateManpower r")})
public class RunDateManpower implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "manpower_type_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private ManpowerType manpowerType;
    @JoinColumn(name = "run_date_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private RunDate runDate;

    public RunDateManpower() {
    }

    public RunDateManpower(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ManpowerType getManpowerType() {
        return manpowerType;
    }

    public void setManpowerType(ManpowerType manpowerType) {
        this.manpowerType = manpowerType;
    }

    public RunDate getRunDate() {
        return runDate;
    }

    public void setRunDate(RunDate runDate) {
        this.runDate = runDate;
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
        if (!(object instanceof RunDateManpower)) {
            return false;
        }
        RunDateManpower other = (RunDateManpower) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.RunDateManpower[ id=" + id + " ]";
    }
    
}
