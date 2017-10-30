package com.trendsmixed.fma.module.production;

import com.trendsmixed.fma.module.operation.Operation;
import com.trendsmixed.fma.module.manpower.Manpower;
import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.productionemployee.ProductionEmployee;
import com.trendsmixed.fma.module.shift.Shift;
import com.trendsmixed.fma.module.shifttype.ShiftType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@EqualsAndHashCode(of = { "id" })
@Table(name = "production")
public class Production implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(ProductionView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(ProductionView.ProductionDate.class)
    @Column(name = "production_date")
    @Temporal(TemporalType.DATE)
    private Date productionDate;
    @JsonView(ProductionView.PlannedDuration.class)
    @Column(name = "planned_duration")
    private Integer plannedDuration;
    @JsonView(ProductionView.ActualDuration.class)
    @Column(name = "actual_duration")
    private Integer actualDuration;
    @JsonView(ProductionView.ControlPoint.class)
    @JoinColumn(name = "control_point_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ControlPoint controlPoint;
    @JsonView(ProductionView.Shift.class)
    @JoinColumn(name = "shift_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Shift shift;
    @JsonView(ProductionView.ShiftType.class)
    @JoinColumn(name = "shift_type_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private ShiftType shiftType;
    @JsonView(ProductionView.Manpower.class)
    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "production")
    private List<Manpower> manpowerList;
    @JsonView(ProductionView.Operation.class)
    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "production")
    private List<Operation> operationList;
    @JsonView(ProductionView.ProductionEmployee.class)
    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "production")
    private List<ProductionEmployee> productionEmployeeList;

    Production(Integer id) {
        this.id = id;
    }

}
