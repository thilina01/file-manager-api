/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.deliveryterm;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.supplier.Supplier;
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
import lombok.NoArgsConstructor;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "delivery_term")
@NamedQueries({
    @NamedQuery(name = "DeliveryTerm .findAll", query = "SELECT i FROM DeliveryTerm  i")})
public class DeliveryTerm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(DeliveryTermView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(DeliveryTermView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(DeliveryTermView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "deliveryTerm")
    private List<Supplier> supplierList;

}
