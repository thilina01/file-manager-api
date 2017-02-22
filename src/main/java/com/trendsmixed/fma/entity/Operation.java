/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.operation.OperationView;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "operation")
@NamedQueries({
    @NamedQuery(name = "Operation.findAll", query = "SELECT p FROM Operation p")})
public class Operation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(OperationView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(OperationView.PlannedQuantity.class)
    @Column(name = "planned_quantity")
    private Integer plannedQuantity;
    @JsonView(OperationView.ActualQuantity.class)
    @Column(name = "actual_quantity")
    private Integer actualQuantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @JsonView(OperationView.UnitWeight.class)
    @Column(name = "unit_weight")
    private Double unitWeight;
    @JsonView(OperationView.Loss.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operation")
    private List<Loss> lossList;
    @JsonView(OperationView.Production.class)
    @JoinColumn(name = "production_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    private Production production;
    @JsonView(OperationView.Job.class)
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Job job;
    @JsonView(OperationView.OperationType.class)
    @JoinColumn(name = "operation_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false, cascade = CascadeType.REMOVE)
    private OperationType operationType;
    @JsonView(OperationView.ProductType.class)
    @JoinColumn(name = "product_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false, cascade = CascadeType.REMOVE)
    private ProductType productType;

    public Operation() {
    }

    public Operation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlannedQuantity() {
        return plannedQuantity;
    }

    public void setPlannedQuantity(Integer plannedQuantity) {
        this.plannedQuantity = plannedQuantity;
    }

    public Integer getActualQuantity() {
        return actualQuantity;
    }

    public void setActualQuantity(Integer actualQuantity) {
        this.actualQuantity = actualQuantity;
    }

    public Double getUnitWeight() {
        return unitWeight;
    }

    public void setUnitWeight(Double unitWeight) {
        this.unitWeight = unitWeight;
    }

    public List<Loss> getLossList() {
        return lossList;
    }

    public void setLossList(List<Loss> lossList) {
        this.lossList = lossList;
    }

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
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
        if (!(object instanceof Operation)) {
            return false;
        }
        Operation other = (Operation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.Operation[ id=" + id + " ]";
    }

}
