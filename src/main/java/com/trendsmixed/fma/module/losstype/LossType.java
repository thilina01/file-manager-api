/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.losstype;

import com.trendsmixed.fma.module.lossreason.LossReason;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.losstype.LossTypeView;
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
@Table(name = "loss_type")
@NamedQueries({
    @NamedQuery(name = "LossType.findAll", query = "SELECT l FROM LossType l")})
public class LossType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(LossTypeView.Id.class)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JsonView(LossTypeView.Code.class)
    @Column(name = "code", length = 45)
    private String code;
    @JsonView(LossTypeView.Name.class)
    @Column(name = "name", length = 250)
    private String name;
    @JsonView(LossTypeView.TypeInSinhala.class)
    @Column(name = "type_in_sinhala", length = 250)
    private String typeInSinhala;
    @JsonView(LossTypeView.LossReasonList.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lossType")
    private List<LossReason> lossReasonList;

    public LossType() {
    }

    public LossType(Integer id) {
        this.id = id;
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
