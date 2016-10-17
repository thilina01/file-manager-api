/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.entity;

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
@Table(name = "job")
@NamedQueries({
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j")})
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "actual_sipped_date")
    @Temporal(TemporalType.DATE)
    private Date actualSippedDate;
    @Column(name = "comment")
    private String comment;
    @Column(name = "confirm_shipped_date")
    @Temporal(TemporalType.DATE)
    private Date confirmShippedDate;
    @Column(name = "job_date")
    @Temporal(TemporalType.DATE)
    private Date jobDate;
    @Column(name = "job_no")
    private String jobNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "job_quantity")
    private Double jobQuantity;
    @JoinColumns({
        @JoinColumn(name = "purchase_order_has_item_item_id", referencedColumnName = "item_id")
        , @JoinColumn(name = "purchase_order_has_item_purchase_order_id", referencedColumnName = "purchase_order_id")})
    @ManyToOne(optional = false)
    private PurchaseOrderHasItem purchaseOrderHasItem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job")
    private List<JobHasControlPoint> jobHasControlPointList;

    public Job() {
    }

    public Job(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getActualSippedDate() {
        return actualSippedDate;
    }

    public void setActualSippedDate(Date actualSippedDate) {
        this.actualSippedDate = actualSippedDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getConfirmShippedDate() {
        return confirmShippedDate;
    }

    public void setConfirmShippedDate(Date confirmShippedDate) {
        this.confirmShippedDate = confirmShippedDate;
    }

    public Date getJobDate() {
        return jobDate;
    }

    public void setJobDate(Date jobDate) {
        this.jobDate = jobDate;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public Double getJobQuantity() {
        return jobQuantity;
    }

    public void setJobQuantity(Double jobQuantity) {
        this.jobQuantity = jobQuantity;
    }

    public PurchaseOrderHasItem getPurchaseOrderHasItem() {
        return purchaseOrderHasItem;
    }

    public void setPurchaseOrderHasItem(PurchaseOrderHasItem purchaseOrderHasItem) {
        this.purchaseOrderHasItem = purchaseOrderHasItem;
    }

    public List<JobHasControlPoint> getJobHasControlPointList() {
        return jobHasControlPointList;
    }

    public void setJobHasControlPointList(List<JobHasControlPoint> jobHasControlPointList) {
        this.jobHasControlPointList = jobHasControlPointList;
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
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.Job[ id=" + id + " ]";
    }
    
}
