package com.trendsmixed.fma.module.job;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.dispatchschedule.DispatchSchedule;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.jobtype.JobType;
import com.trendsmixed.fma.module.subcontractoperation.SubcontractOperation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "job")
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
    @Column(name = "job_no", unique = true)
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
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "job", fetch = FetchType.LAZY)
    private List<SubcontractOperation> subcontractOperationList;

    public Job(Integer id) {
        this.id = id;
    }
    @JsonView(JobView.All.class)
    public String getDisplay() {
        return jobNo + " : " + item.getCode();
    }
}
