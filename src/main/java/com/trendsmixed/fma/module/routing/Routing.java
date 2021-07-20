package com.trendsmixed.fma.module.routing;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.materialtype.MaterialType;
import com.trendsmixed.fma.module.operationtype.OperationType;
import com.trendsmixed.fma.module.skill.Skill;
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
@Table(name = "routing")
public class Routing implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(RoutingView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(RoutingView.Sequence.class)
    @Column(name = "sequence")
    private int sequence;
    @JsonView(RoutingView.PerShiftCapacity.class)
    @Column(name = "per_shift_capacity")
    private double perShiftCapacity;
    @JsonView(RoutingView.ManMinutes.class)
    @Column(name = "man_minutes")
    private double manMinutes;
    @JsonView(RoutingView.HeadCount.class)
    @Column(name = "head_count")
    private int headCount;
    @JsonView(RoutingView.Description.class)
    @Column(name = "description")
    private String description;
    @JsonView(RoutingView.Item.class)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Item item;
    @JsonView(RoutingView.ControlPoint.class)
    @JoinColumn(name = "control_point_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ControlPoint controlPoint;
    @JsonView(RoutingView.Skill.class)
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Skill skill;
    @JsonView(RoutingView.OperationType.class)
    @JoinColumn(name = "operation_type_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private OperationType operationType;
    @JsonView(RoutingView.MaterialType.class)
    @JoinColumn(name = "material_type_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private MaterialType materialType;

}
