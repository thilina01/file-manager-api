/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.manpower;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.manpowertype.ManpowerType;
import com.trendsmixed.fma.module.production.Production;
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
@Table(name = "manpower")
@NamedQueries({
    @NamedQuery(name = "Manpower.findAll", query = "SELECT m FROM Manpower m")})
public class Manpower implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(ManpowerView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(ManpowerView.PlannedQuantity.class)
    @Column(name = "planned_quantity")
    private Integer plannedQuantity;
    @JsonView(ManpowerView.ActualQuantity.class)
    @Column(name = "actual_quantity")
    private Integer actualQuantity;
    @JsonView(ManpowerView.ManpowerType.class)
    @JoinColumn(name = "manpower_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)//, cascade = CascadeType.DETACH
    private ManpowerType manpowerType;
    @JsonView(ManpowerView.Production.class)
    @JoinColumn(name = "production_id", referencedColumnName = "id")
    @ManyToOne(optional = false)//, cascade = CascadeType.DETACH
    private Production production;

}
