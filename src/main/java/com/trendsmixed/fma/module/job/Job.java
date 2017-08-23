/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.job;

import com.trendsmixed.fma.module.item.Item;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.dispatchschedule.DispatchSchedule;
import com.trendsmixed.fma.module.jobtype.JobType;
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
import lombok.NoArgsConstructor;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "job")
@NamedQueries({
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j")})
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(JobView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(JobView.JobDate.class)
    @Column(name = "job_date")
    @Temporal(TemporalType.DATE)
    private Date jobDate;
    @JsonView(JobView.JobNo.class)
    @Column(name = "job_no",unique=true)
    private String jobNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @JsonView(JobView.Quantity.class)
    @Column(name = "quantity")
    private Double quantity;
    @JsonView(JobView.Item.class)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Item item;
    @JsonView(JobView.JobType.class)
    @JoinColumn(name = "job_type_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private JobType jobType;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "job")
    private List<DispatchSchedule> dispatchScheduleList;

    public Job(Integer id) {
        this.id = id;
    }

}
