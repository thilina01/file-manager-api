/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.operationtype;

import com.trendsmixed.fma.module.operation.Operation;
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

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@Table(name = "operation_type")
@NamedQueries({
    @NamedQuery(name = "OperationType.findAll", query = "SELECT o FROM OperationType o")})
public class OperationType implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(OperationTypeView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(OperationTypeView.Code.class)
    @Column(name = "code")
    private String code;
    @JsonView(OperationTypeView.Description.class)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "operationType")
    private List<Operation> operationList;

    public OperationType() {
    }

    public OperationType(Integer id) {
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
        if (!(object instanceof OperationType)) {
            return false;
        }
        OperationType other = (OperationType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.OperationType[ id=" + id + " ]";
    }

}
