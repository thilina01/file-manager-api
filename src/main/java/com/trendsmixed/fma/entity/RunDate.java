/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.RunDateView;
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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "run_date")
@NamedQueries({
    @NamedQuery(name = "RunDate.findAll", query = "SELECT r FROM RunDate r")})
public class RunDate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(RunDateView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(RunDateView.Duration.class)
    @Column(name = "duration")
    private Integer duration;
    @JsonView(RunDateView.Quantity.class)
    @Column(name = "quantity")
    private Integer quantity;
    @JsonView(RunDateView.Repaired.class)
    @Column(name = "repaired")
    private Integer repaired;
    @JsonView(RunDateView.Rework.class)
    @Column(name = "rework")
    private Integer rework;
    @JsonView(RunDateView.RunDate.class)
    @Column(name = "run_date")
    @Temporal(TemporalType.DATE)
    private Date runDate;
    @JsonView(RunDateView.Scrap.class)
    @Column(name = "scrap")
    private Integer scrap;
    @JsonView(RunDateView.Shift.class)
    @Column(name = "shift")
    private String shift;
    @JoinTable(name = "run_date_has_loss_reason", joinColumns = {
        @JoinColumn(name = "run_date_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "loss_reason_id", referencedColumnName = "id")})
    @ManyToMany
    private List<LossReason> lossReasonList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "runDate")
    private List<RunDateHasManpowerType> runDateHasManpowerTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "runDate")
    private List<RunDateHasScrapType> runDateHasScrapTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "runDate")
    private List<RunDateHasDefectType> runDateHasDefectTypeList;
    @JoinColumns({
        @JoinColumn(name = "job_has_control_point_control_point_id", referencedColumnName = "control_point_id"),
        @JoinColumn(name = "job_has_control_point_job_id", referencedColumnName = "job_id")})
    @ManyToOne(optional = false)
    private JobHasControlPoint jobHasControlPoint;

    public RunDate() {
    }

    public RunDate(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getRepaired() {
        return repaired;
    }

    public void setRepaired(Integer repaired) {
        this.repaired = repaired;
    }

    public Integer getRework() {
        return rework;
    }

    public void setRework(Integer rework) {
        this.rework = rework;
    }

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }

    public Integer getScrap() {
        return scrap;
    }

    public void setScrap(Integer scrap) {
        this.scrap = scrap;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public List<LossReason> getLossReasonList() {
        return lossReasonList;
    }

    public void setLossReasonList(List<LossReason> lossReasonList) {
        this.lossReasonList = lossReasonList;
    }

    public List<RunDateHasManpowerType> getRunDateHasManpowerTypeList() {
        return runDateHasManpowerTypeList;
    }

    public void setRunDateHasManpowerTypeList(List<RunDateHasManpowerType> runDateHasManpowerTypeList) {
        this.runDateHasManpowerTypeList = runDateHasManpowerTypeList;
    }

    public List<RunDateHasScrapType> getRunDateHasScrapTypeList() {
        return runDateHasScrapTypeList;
    }

    public void setRunDateHasScrapTypeList(List<RunDateHasScrapType> runDateHasScrapTypeList) {
        this.runDateHasScrapTypeList = runDateHasScrapTypeList;
    }

    public List<RunDateHasDefectType> getRunDateHasDefectTypeList() {
        return runDateHasDefectTypeList;
    }

    public void setRunDateHasDefectTypeList(List<RunDateHasDefectType> runDateHasDefectTypeList) {
        this.runDateHasDefectTypeList = runDateHasDefectTypeList;
    }

    public JobHasControlPoint getJobHasControlPoint() {
        return jobHasControlPoint;
    }

    public void setJobHasControlPoint(JobHasControlPoint jobHasControlPoint) {
        this.jobHasControlPoint = jobHasControlPoint;
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
        if (!(object instanceof RunDate)) {
            return false;
        }
        RunDate other = (RunDate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.RunDate[ id=" + id + " ]";
    }

}
