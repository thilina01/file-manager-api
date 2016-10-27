/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.RunDateDefectView;
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
@Table(name = "run_date_defect")
@NamedQueries({
    @NamedQuery(name = "RunDateDefect.findAll", query = "SELECT r FROM RunDateDefect r")})
public class RunDateDefect implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(RunDateDefectView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(RunDateDefectView.Quantity.class)
    @Column(name = "quantity")
    private Integer quantity;
    @JsonView(RunDateDefectView.DefectType.class)
    @JoinColumn(name = "defect_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DefectType defectType;
    @JsonView(RunDateDefectView.RunDate.class)
    @JoinColumn(name = "run_date_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RunDate runDate;

    public RunDateDefect() {
    }

    public RunDateDefect(Integer id) {
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

    public DefectType getDefectType() {
        return defectType;
    }

    public void setDefectType(DefectType defectType) {
        this.defectType = defectType;
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
        if (!(object instanceof RunDateDefect)) {
            return false;
        }
        RunDateDefect other = (RunDateDefect) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.RunDateDefect[ id=" + id + " ]";
    }
    
}
