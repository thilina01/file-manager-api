package com.trendsmixed.fma.module.controlpointtype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.controlpoint.ControlPoint;
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
@Table(name = "control_point_type")
public class ControlPointType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ControlPointTypeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ControlPointTypeView.Code.class)
    @Column(name = "code")
    private String code;
    @JsonView(ControlPointTypeView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "controlPointType")
    private List<ControlPoint> controlPointList;

    public ControlPointType(Integer id) {
        this.id = id;
    }
    @JsonView(ControlPointTypeView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
