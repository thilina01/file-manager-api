package com.trendsmixed.fma.module.machine;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.accident.Accident;
import com.trendsmixed.fma.module.breakdown.Breakdown;
import com.trendsmixed.fma.module.controlpointmachine.ControlPointMachine;
import com.trendsmixed.fma.module.resourceutilization.ResourceUtilization;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "machine")
public class Machine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(MachineView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(MachineView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @JsonView(MachineView.EnergyRate.class)
    @Column(name = "energy_rate")
    private Double energyRate;
    @JsonView(MachineView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "machine")
    private List<Breakdown> breakdownList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "machine")
    private List<ControlPointMachine> controlPointMachineList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "machine")
    private List<Accident> accidentList;
    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "machine")
    private List<ResourceUtilization> resourceUtilizationList;

    public Machine(Integer id) {
        this.id = id;
    }

    @JsonView(MachineView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
