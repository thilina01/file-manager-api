package com.trendsmixed.fma.module.workcenter;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.costcenter.CostCenter;
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
@Table(name = "work_center")
public class WorkCenter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(WorkCenterView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(WorkCenterView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(WorkCenterView.Name.class)
    @Column(name = "name")
    private String name;
    @JsonView(WorkCenterView.ControlPoint.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "workCenter")
    private List<ControlPoint> controlPointList;
    @JsonView(WorkCenterView.CostCenter.class)
    @JoinColumn(name = "cost_center_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CostCenter costCenter;

    @JsonView(WorkCenterView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
