package com.trendsmixed.fma.module.jobtype;

import com.trendsmixed.fma.module.job.Job;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
@Table(name = "job_type", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@NamedQueries({
    @NamedQuery(name = "JobType.findAll", query = "SELECT j FROM JobType j")})
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

}
