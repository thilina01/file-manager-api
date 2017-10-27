package com.trendsmixed.fma.module.costcenter;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.workcenter.WorkCenter;
import java.io.Serializable;
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
@EqualsAndHashCode(of = {"id"})
@Table(name = "cost_center")
public class CostCenter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(CostCenterView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(CostCenterView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(CostCenterView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "costCenter")
    private List<WorkCenter> workCenterList;
    @JsonView(CostCenterView.Section.class)
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Section section;

}
