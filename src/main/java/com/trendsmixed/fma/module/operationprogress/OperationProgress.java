package com.trendsmixed.fma.module.operationprogress;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.operation.Operation;
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
@Table(name = "operation_progress")
public class OperationProgress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(OperationProgressView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(OperationProgressView.TimeSlot.class)
    @Column(name = "time_slot")
    private Date timeSlot;
    @JsonView(OperationProgressView.Quantity.class)
    @Column(name = "quantity")
    private Double quantity;
    @JsonView(OperationProgressView.Operation.class)
    @JoinColumn(name = "operation_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Operation operation;

    @JsonView(OperationProgressView.All.class)
    public String getDisplay() {
        return operation.getId() + " : " + timeSlot + " : " + quantity;
    }
}
