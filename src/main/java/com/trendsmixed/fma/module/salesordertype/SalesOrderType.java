/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.salesordertype;

import com.trendsmixed.fma.module.salesorder.SalesOrder;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.salesordertype.SalesOrderTypeView;
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
@Table(name = "sales_order_type")
@NamedQueries({
    @NamedQuery(name = "SalesOrderType.findAll", query = "SELECT o FROM SalesOrderType o")})
public class SalesOrderType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(SalesOrderTypeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(SalesOrderTypeView.Code.class)
    @Column(name = "code")
    private String code;
    @JsonView(SalesOrderTypeView.Type.class)
    @Column(name = "type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesOrderType")
    private List<SalesOrder> salesOrderList;

    public SalesOrderType() {
    }

    public SalesOrderType(Integer id) {
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

    public List<SalesOrder> getSalesOrderList() {
        return salesOrderList;
    }

    public void setSalesOrderList(List<SalesOrder> salesOrderList) {
        this.salesOrderList = salesOrderList;
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
        if (!(object instanceof SalesOrderType)) {
            return false;
        }
        SalesOrderType other = (SalesOrderType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.SalesOrderType[ id=" + id + " ]";
    }
    
}
