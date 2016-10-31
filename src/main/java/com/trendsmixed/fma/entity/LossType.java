/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

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
@Table(name = "loss_type")
@NamedQueries({
    @NamedQuery(name = "LossType.findAll", query = "SELECT l FROM LossType l")})
public class LossType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "code", length = 45)
    private String code;
    @Column(name = "type", length = 250)
    private String type;
    @Column(name = "type_in_sinhala", length = 250)
    private String typeInSinhala;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lossType")
    private List<LossReason> lossReasonList;

    public LossType() {
    }

    public LossType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeInSinhala() {
        return typeInSinhala;
    }

    public void setTypeInSinhala(String typeInSinhala) {
        this.typeInSinhala = typeInSinhala;
    }

    public List<LossReason> getLossReasonList() {
        return lossReasonList;
    }

    public void setLossReasonList(List<LossReason> lossReasonList) {
        this.lossReasonList = lossReasonList;
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
        if (!(object instanceof LossType)) {
            return false;
        }
        LossType other = (LossType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.LossType[ id=" + id + " ]";
    }
    
}
