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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
    @Column(name = "reason")
    private String reason;
    @Column(name = "reason_in_shinhala")
    private String reasonInShinhala;
    @ManyToMany(mappedBy = "lossReasonList")
    private List<RunDate> runDateList;
    @JoinColumn(name = "loss_type_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private LossType lossType;

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReasonInShinhala() {
        return reasonInShinhala;
    }

    public void setReasonInShinhala(String reasonInShinhala) {
        this.reasonInShinhala = reasonInShinhala;
    }

    public List<RunDate> getRunDateList() {
        return runDateList;
    }

    public void setRunDateList(List<RunDate> runDateList) {
        this.runDateList = runDateList;
    }

    public LossType getLossType() {
        return lossType;
    }

    public void setLossType(LossType lossType) {
        this.lossType = lossType;
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
