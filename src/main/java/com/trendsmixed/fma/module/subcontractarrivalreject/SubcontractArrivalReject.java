package com.trendsmixed.fma.module.subcontractarrivalreject;

import com.trendsmixed.fma.module.lossreason.LossReason;
import com.trendsmixed.fma.module.subcontractarrival.SubcontractArrival;
import com.trendsmixed.fma.module.subcontractoperation.SubcontractOperation;

import java.io.Serializable;
import java.util.Date;

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
  
    @JsonView(SubcontractArrivalRejectView.All.class)
    public String getDisplay() {
        return id + " : "; 
        
    }

}
