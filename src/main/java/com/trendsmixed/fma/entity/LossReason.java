/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.LossReasonView;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "loss_reason")
@NamedQueries({
    @NamedQuery(name = "LossReason.findAll", query = "SELECT l FROM LossReason l")})
public class LossReason implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(LossReasonView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(LossReasonView.Code.class)
    @Column(name = "code")
    private String code;
    @JsonView(LossReasonView.Type.class)
    @Column(name = "type")
    private String type;
    @JsonView(LossReasonView.TypeInSinhala.class)
    @Column(name = "type_in_sinhala")
    private String typeInSinhala;
    @ManyToMany(mappedBy = "lossReasonList")
    private List<RunDate> runDateList;

    public LossReason() {
    }

    public LossReason(Integer id) {
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

    public List<RunDate> getRunDateList() {
        return runDateList;
    }

    public void setRunDateList(List<RunDate> runDateList) {
        this.runDateList = runDateList;
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
        if (!(object instanceof LossReason)) {
            return false;
        }
        LossReason other = (LossReason) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.LossReason[ id=" + id + " ]";
    }
    
}
