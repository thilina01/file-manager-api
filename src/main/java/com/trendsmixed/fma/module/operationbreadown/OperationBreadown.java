package com.trendsmixed.fma.module.operationbreadown;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.breakdown.Breakdown;
import com.trendsmixed.fma.module.operation.Operation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "operation_breakdown")
public class OperationBreadown implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(OperationBreadownView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(OperationBreadownView.Operation.class)
    @JoinColumn(name = "operation_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Operation operation;
    @JsonView(OperationBreadownView.Breakdown.class)
    @JoinColumn(name = "breakdown_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Breakdown breakdown;

}
