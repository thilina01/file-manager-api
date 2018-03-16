package com.trendsmixed.fma.module.section;

import com.trendsmixed.fma.module.costcenter.CostCenter;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.accident.Accident;
import com.trendsmixed.fma.module.employee.Employee;
import com.trendsmixed.fma.module.sectiontype.SectionType;
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
@Table(name = "section")
public class Section implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(SectionView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(SectionView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(SectionView.Name.class)
    @Column(name = "name")
    private String name;
    @JsonView(SectionView.MTBFTarget.class)
    @Column(name = "mtbf_target")
    private Double mtbfTarget;
    @JsonView(SectionView.MTTRTarget.class)
    @Column(name = "mttr_target")
    private Double mttrTarget;
    @JsonView(SectionView.MDTTarget.class)
    @Column(name = "mdt_target")
    private Double mdtTarget;
    @JsonView(SectionView.SectionType.class)
    @JoinColumn(name = "section_type_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private SectionType sectionType;
    @JsonView(SectionView.CostCenter.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "section")
    private List<CostCenter> costCenterList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "section")
    private List<Accident> accidentList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "section")
    private List<Employee> employeeList;

    public Section(Integer id) {
        this.id = id;
    }

    @JsonView(SectionView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
