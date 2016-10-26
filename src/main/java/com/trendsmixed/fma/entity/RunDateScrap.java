/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.RunDateScrapView;
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
@Table(name = "run_date_scrap")
@NamedQueries({
    @NamedQuery(name = "RunDateScrap.findAll", query = "SELECT r FROM RunDateScrap r")})
public class RunDateScrap implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(RunDateScrapView.Quantity.class)
    @Column(name = "quantity")
    private String quantity;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(RunDateScrapView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(RunDateScrapView.RunDate.class)
    @JoinColumn(name = "run_date_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private RunDate runDate;
    @JsonView(RunDateScrapView.ScrapType.class)
    @JoinColumn(name = "scrap_type_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private ScrapType scrapType;

    public RunDateScrap() {
    }

    public RunDateScrap(Integer id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RunDate getRunDate() {
        return runDate;
    }

    public void setRunDate(RunDate runDate) {
        this.runDate = runDate;
    }

    public ScrapType getScrapType() {
        return scrapType;
    }

    public void setScrapType(ScrapType scrapType) {
        this.scrapType = scrapType;
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
        if (!(object instanceof RunDateScrap)) {
            return false;
        }
        RunDateScrap other = (RunDateScrap) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.RunDateScrap[ id=" + id + " ]";
    }
    
}
