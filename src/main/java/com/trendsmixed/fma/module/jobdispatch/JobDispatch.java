package com.trendsmixed.fma.module.jobdispatch;

import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.dispatch.Dispatch;
import com.fasterxml.jackson.annotation.JsonView;
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
@Table(name = "job_dispatch")
@NamedQueries({
    @NamedQuery(name = "JobDispatch.findAll", query = "SELECT j FROM JobDispatch j")})
public class JobDispatch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @JsonView(JobDispatchView.Id.class)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantity")
    @JsonView(JobDispatchView.Quantity.class)
    private Double quantity;
    @JoinColumn(name = "dispatch_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonView(JobDispatchView.Dispatch.class)
    private Dispatch dispatch;
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonView(JobDispatchView.Job.class)
    private Job job;

}
