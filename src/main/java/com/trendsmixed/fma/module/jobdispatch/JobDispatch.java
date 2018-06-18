package com.trendsmixed.fma.module.jobdispatch;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.dispatch.Dispatch;
import com.trendsmixed.fma.module.job.Job;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "job_dispatch")
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
