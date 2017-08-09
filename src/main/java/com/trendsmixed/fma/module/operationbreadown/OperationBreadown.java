/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.operationbreadown;

import com.trendsmixed.fma.module.operation.Operation;
import com.trendsmixed.fma.module.breakdown.Breakdown;
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
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@Table(name = "operation_breakdown")
@NamedQueries({
    @NamedQuery(name = "OperationBreadown.findAll", query = "SELECT o FROM OperationBreadown o")})
public class OperationBreadown implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(OperationBreadownView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(OperationBreadownView.Operation.class)
    @JoinColumn(name = "operation_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Operation operation;
    @JsonView(OperationBreadownView.Breakdown.class)
    @JoinColumn(name = "breakdown_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Breakdown breakdown;

}
