/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.breakdown;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.machine.Machine;
import com.trendsmixed.fma.module.operationbreadown.OperationBreadown;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@Table(name = "breakdown")
@NamedQueries({
    @NamedQuery(name = "Breakdown.findAll", query = "SELECT b FROM Breakdown b")})
public class Breakdown implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(BreakdownView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(BreakdownView.Date.class)
    @Column(name = "breakdown_date")
    @Temporal(TemporalType.DATE)
    private Date breakdownDate;
    @JsonView(BreakdownView.Duration.class)
    @Column(name = "duration")
    private Integer duration;
    @JsonView(BreakdownView.BreakdownTime.class)
    @Column(name = "breakdown_time")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date breakdownTime;
    @JsonView(BreakdownView.RecoveryTime.class)
    @Column(name = "recovery_time")
    //@Temporal(TemporalType.TIME)
    private Date recoveryTime;
    @JsonView(BreakdownView.BreakdownNumber.class)
    @Column(name = "breakdown_number")
    private String breakdownNumber;
    @JsonView(BreakdownView.Description.class)
    @Column(name = "description")
    private String description;
    @JsonView(BreakdownView.Machine.class)
    @JoinColumn(name = "machine_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Machine machine;
    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "breakdown")
    private List<OperationBreadown> operationBreadownList;

}
