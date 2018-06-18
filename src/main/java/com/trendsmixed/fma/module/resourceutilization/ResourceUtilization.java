package com.trendsmixed.fma.module.resourceutilization;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.employee.Employee;
import com.trendsmixed.fma.module.machine.Machine;
import com.trendsmixed.fma.module.production.Production;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "resource_utilization")
public class ResourceUtilization implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ResourceUtilizationView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ResourceUtilizationView.StartTime.class)
    @Column(name = "start_time")
    private Date startTime;
    @JsonView(ResourceUtilizationView.EndTime.class)
    @Column(name = "end_time")
    private Date endTime;
    @JsonView(ResourceUtilizationView.Production.class)
    @JoinColumn(name = "production_id", referencedColumnName = "id")
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, optional = false)
    private Production production;
    @JsonView(ResourceUtilizationView.Employee.class)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Employee employee;
    @JsonView(ResourceUtilizationView.Machine.class)
    @JoinColumn(name = "machine_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Machine machine;

}

