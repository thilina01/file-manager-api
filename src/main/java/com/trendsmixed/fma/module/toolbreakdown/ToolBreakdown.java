/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.toolbreakdown;

import com.trendsmixed.fma.module.tool.Tool;
import com.fasterxml.jackson.annotation.JsonView;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "tool_breakdown")
@NamedQueries({
    @NamedQuery(name = "ToolBreakdown.findAll", query = "SELECT b FROM ToolBreakdown b")})
public class ToolBreakdown implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ToolBreakdownView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ToolBreakdownView.Date.class)
    @Column(name = "toolBreakdown_date")
    @Temporal(TemporalType.DATE)
    private Date toolBreakdownDate;
    @JsonView(ToolBreakdownView.Duration.class)
    @Column(name = "duration")
    private Integer duration;
    @JsonView(ToolBreakdownView.BreakdownTime.class)
    @Column(name = "toolBreakdown_time")
    private Date toolBreakdownTime;
    @JsonView(ToolBreakdownView.RecoveryTime.class)
    @Column(name = "recovery_time")
    private Date recoveryTime;
    @JsonView(ToolBreakdownView.BreakdownNumber.class)
    @Column(name = "toolBreakdown_number")
    private String toolBreakdownNumber;
    @JsonView(ToolBreakdownView.Description.class)
    @Column(name = "description")
    private String description;
    @JsonView(ToolBreakdownView.Tool.class)
    @JoinColumn(name = "tool_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tool tool;

}
