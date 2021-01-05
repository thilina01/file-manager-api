package com.trendsmixed.fma.module.operation;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.loss.Loss;
import com.trendsmixed.fma.module.operationbreadown.OperationBreadown;
import com.trendsmixed.fma.module.operationprogress.OperationProgress;
import com.trendsmixed.fma.module.operationtype.OperationType;
import com.trendsmixed.fma.module.production.Production;
import com.trendsmixed.fma.module.producttype.ProductType;
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
@Table(name = "operation")
public class Operation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(OperationView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(OperationView.PlannedQuantity.class)
    @Column(name = "planned_quantity")
    private Integer plannedQuantity;
    @JsonView(OperationView.ActualQuantity.class)
    @Column(name = "actual_quantity")
    private Integer actualQuantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @JsonView(OperationView.UnitWeight.class)
    @Column(name = "unit_weight")
    private Double unitWeight;
    @JsonView(OperationView.StartTime.class)
    @Column(name = "start_time")
    private Date startTime;
    @JsonView(OperationView.EndTime.class)
    @Column(name = "end_time")
    private Date endTime;
    @JsonView(OperationView.Loss.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "operation")
    private List<Loss> lossList;
    @JsonView(OperationView.Production.class)
    @JoinColumn(name = "production_id", referencedColumnName = "id")
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, optional = false)
    private Production production;
    @JsonView(OperationView.Job.class)
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Job job;
    @JsonView(OperationView.OperationType.class)
    @JoinColumn(name = "operation_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OperationType operationType;
    @JsonView(OperationView.ProductType.class)
    @JoinColumn(name = "product_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductType productType;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "operation")
    private List<OperationBreadown> operationBreadownList;
    @JsonView(OperationView.OperationProgress.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "operation")
    private List<OperationProgress> operationProgressList;

}
