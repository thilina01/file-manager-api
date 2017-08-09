/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.salesordertype;

import com.trendsmixed.fma.module.salesorder.SalesOrder;
import com.fasterxml.jackson.annotation.JsonView;
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
import lombok.EqualsAndHashCode;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@EqualsAndHashCode(of = {"id"})
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
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "salesOrderType")
    private List<SalesOrder> salesOrderList;

}
