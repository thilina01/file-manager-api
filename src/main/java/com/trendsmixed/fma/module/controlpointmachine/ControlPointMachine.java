package com.trendsmixed.fma.module.controlpointmachine;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.machine.Machine;
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
@Table(name = "control_point_machine")
public class ControlPointMachine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ControlPointMachineView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ControlPointMachineView.ControlPoint.class)
    @JoinColumn(name = "control_point_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ControlPoint controlPoint;
    @JsonView(ControlPointMachineView.Machine.class)
    @JoinColumn(name = "machine_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Machine machine;

}
