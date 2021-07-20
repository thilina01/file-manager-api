package com.trendsmixed.fma.module.operationdemand;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.routing.Routing;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "operation_demand")
public class OperationDemand implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(OperationDemandView.Id.class)
    @Column(name = "id")
    private Integer id;

    @JsonView(OperationDemandView.Quantity.class)
    @Column(name = "quantity")
    private Integer quantity;

    @JsonView(OperationDemandView.ManufacturedQuantity.class)
    @Column(name = "manufactured_quantity")
    private Integer manufacturedQuantity;

    @JsonView(OperationDemandView.Job.class)
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Job job;

    @JsonView(OperationDemandView.Routing.class)
    @JoinColumn(name = "routing_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Routing routing;

}
