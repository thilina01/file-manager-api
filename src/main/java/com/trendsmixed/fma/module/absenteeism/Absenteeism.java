/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.absenteeism;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.labourtursource.LabourSource;
import java.io.Serializable;
import java.util.Date;
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
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@Table(name = "absenteeism")
@NamedQueries({
    @NamedQuery(name = "Absenteeism.findAll", query = "SELECT c FROM Absenteeism c")})
public class Absenteeism implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(AbsenteeismView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(AbsenteeismView.EffectiveMonth.class)
    @Column(name = "effective_month")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date effectiveMonth;
    @JsonView(AbsenteeismView.Absenteeism.class)
    @Column(name = "absenteeism")
    private double absenteeism;
    @JsonView(AbsenteeismView.Target.class)
    @Column(name = "target")
    private double target;
    @JsonView(AbsenteeismView.LabourSource.class)
    @JoinColumn(name = "labour_source_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LabourSource labourSource;

}
