package com.trendsmixed.fma.module.loss;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.lossreason.LossReason;
import com.trendsmixed.fma.module.operation.Operation;
import java.io.Serializable;
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
@Table(name = "loss", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"loss_reason_id", "operation_id"})})
public class Loss implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(LossView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(LossView.Quantity.class)
    @Column(name = "quantity")
    private Integer quantity;
    @JsonView(LossView.LossReason.class)
    @JoinColumn(name = "loss_reason_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LossReason lossReason;
    @JsonView(LossView.Operation.class)
    @JoinColumn(name = "operation_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    private Operation operation;

}
