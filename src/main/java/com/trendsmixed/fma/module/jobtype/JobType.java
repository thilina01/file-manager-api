package com.trendsmixed.fma.module.jobtype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.job.Job;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "job_type", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
public class JobType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(JobTypeView.Id.class)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JsonView(JobTypeView.Code.class)
    @Column(name = "code", length = 50, unique = true)
    private String code;
    @JsonView(JobTypeView.Name.class)
    @Column(name = "name", length = 250)
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "jobType")
    private List<Job> jobList;

    @JsonView(JobTypeView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
