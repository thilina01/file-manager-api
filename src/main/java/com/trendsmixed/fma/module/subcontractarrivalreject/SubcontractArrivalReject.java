package com.trendsmixed.fma.module.subcontractarrivalreject;

import com.trendsmixed.fma.module.lossreason.LossReason;
import com.trendsmixed.fma.module.subcontractarrival.SubcontractArrival;
import com.trendsmixed.fma.module.subcontractreworkoperation.SubcontractReworkOperation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "subcontract_arrival_reject")
public class SubcontractArrivalReject implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(SubcontractArrivalRejectView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(SubcontractArrivalRejectView.ArrivalRejectDate.class)
    @Column(name = "arrival_reject_date")
    private Date arrivalRejectDate;
    @JsonView(SubcontractArrivalRejectView.Quantity.class)
    @Column(name = "quantity")
    private Integer quantity;
    @JsonView(SubcontractArrivalRejectView.LossReason.class)
    @JoinColumn(name = "loss_reason_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LossReason lossReason;
    @JsonView(SubcontractArrivalRejectView.SubcontractArrival.class)
    @JoinColumn(name = "subcontract_arrival_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubcontractArrival subcontractArrival;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "subcontractArrivalReject")
    private List<SubcontractReworkOperation> subcontractReworkOperationList;
    @JsonView(SubcontractArrivalRejectView.All.class)
    public String getDisplay() {
    return id + " : " +subcontractArrival.getSubcontractOperation().getJob().getJobNo()+ " | " +subcontractArrival.getSubcontractOperation().getSubcontractOperationRate().subcontractorOperation.getSubcontractOperationDefinition().getProductType().getCode()+ " | " +subcontractArrival.getSubcontractOperation().getSubcontractOperationRate().subcontractorOperation.getSubcontractOperationDefinition().getOperationType().getCode()+ " | " +lossReason.getName();    
    }

}
