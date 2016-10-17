/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
    @Column(name = "id")
    private Integer id;
    @Column(name = "run_date")
    @Temporal(TemporalType.DATE)
    private Date runDate;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "scrap")
    private Integer scrap;
    @Column(name = "repaierd")
    private Integer repaierd;
    @Column(name = "rework")
    private Integer rework;
    @Column(name = "shift")
    private String shift;
    @ManyToMany(mappedBy = "runDateCollection")
    private Collection<LossReason> lossReasonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "runDate")
    private Collection<RunDateHasManpowerType> runDateHasManpowerTypeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "runDate")
    private Collection<RunDateHasScrapType> runDateHasScrapTypeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "runDate")
    private Collection<RunDateHasDefectType> runDateHasDefectTypeCollection;
    @JoinColumns({
        @JoinColumn(name = "job_has_control_point_job_id", referencedColumnName = "job_id")
        , @JoinColumn(name = "job_has_control_point_control_point_id", referencedColumnName = "control_point_id")})
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

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        this.runDate = runDate;
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

    public Integer getScrap() {
        return scrap;
    }

    public void setScrap(Integer scrap) {
        this.scrap = scrap;
    }

    public Integer getRepaierd() {
        return repaierd;
    }

    public void setRepaierd(Integer repaierd) {
        this.repaierd = repaierd;
    }

    public Integer getRework() {
        return rework;
    }

    public void setRework(Integer rework) {
        this.rework = rework;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public Collection<LossReason> getLossReasonCollection() {
        return lossReasonCollection;
    }

    public void setLossReasonCollection(Collection<LossReason> lossReasonCollection) {
        this.lossReasonCollection = lossReasonCollection;
    }

    public Collection<RunDateHasManpowerType> getRunDateHasManpowerTypeCollection() {
        return runDateHasManpowerTypeCollection;
    }

    public void setRunDateHasManpowerTypeCollection(Collection<RunDateHasManpowerType> runDateHasManpowerTypeCollection) {
        this.runDateHasManpowerTypeCollection = runDateHasManpowerTypeCollection;
    }

    public Collection<RunDateHasScrapType> getRunDateHasScrapTypeCollection() {
        return runDateHasScrapTypeCollection;
    }

    public void setRunDateHasScrapTypeCollection(Collection<RunDateHasScrapType> runDateHasScrapTypeCollection) {
        this.runDateHasScrapTypeCollection = runDateHasScrapTypeCollection;
    }

    public Collection<RunDateHasDefectType> getRunDateHasDefectTypeCollection() {
        return runDateHasDefectTypeCollection;
    }

    public void setRunDateHasDefectTypeCollection(Collection<RunDateHasDefectType> runDateHasDefectTypeCollection) {
        this.runDateHasDefectTypeCollection = runDateHasDefectTypeCollection;
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
