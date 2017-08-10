/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.dao;

import lombok.Data;

/**
 *
 * @author Thilina
 */
@Data
public class BreakdownChart {

    private String section;
    private Double runDuration;
    private Double breakdownDuration;
    private Double breakdownCount;
    private Double mtbf;
    private Double mttr;
    private Double mdt;
    private Double mtbfTarget;
    private Double mttrTarget;
    private Double mdtTarget;

    public BreakdownChart(String section, Double runDuration, Double breakdownDuration, Double breakdownCount, Double mtbf, Double mttr, Double mdt, Double mtbfTarget, Double mttrTarget, Double mdtTarget) {
        this.section = section;
        this.runDuration = runDuration;
        this.breakdownDuration = breakdownDuration;
        this.breakdownCount = breakdownCount;
        this.mtbf = mtbf;
        this.mttr = mttr;
        this.mdt = mdt;
        this.mtbfTarget = mtbfTarget;
        this.mttrTarget = mttrTarget;
        this.mdtTarget = mdtTarget;
    }

    public BreakdownChart(Object section, Object runDuration, Object breakdownDuration, Object breakdownCount, Object mtbf, Object mttr, Object mdt, Object mtbfTarget, Object mttrTarget, Object mdtTarget) {
        this.section = section != null ? section.toString() : "";
        this.runDuration = runDuration != null ? new Double(runDuration.toString()) : 0;
        this.breakdownDuration = breakdownDuration != null ? new Double(breakdownDuration.toString()) : 0;
        this.breakdownCount = breakdownCount != null ? new Double(breakdownCount.toString()) : 0;
        this.mtbf = mtbf != null ? new Double(mtbf.toString()) : 0;
        this.mttr = mttr != null ? new Double(mttr.toString()) : 0;
        this.mdt = mdt != null ? new Double(mdt.toString()) : 0;
        this.mtbfTarget = mtbfTarget != null ? new Double(mtbfTarget.toString()) : 0;
        this.mttrTarget = mttrTarget != null ? new Double(mttrTarget.toString()) : 0;
        this.mdtTarget = mdtTarget != null ? new Double(mdtTarget.toString()) : 0;
    }

}
