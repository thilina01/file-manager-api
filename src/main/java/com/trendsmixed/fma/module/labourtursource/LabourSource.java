package com.trendsmixed.fma.module.labourtursource;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.employee.Employee;
import com.trendsmixed.fma.module.labourturnover.LabourTurnover;
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
@Table(name = "labour_source")
public class LabourSource implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(LabourSourceView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(LabourSourceView.Code.class)
    @Column(name = "code")
    private String code;
    @JsonView(LabourSourceView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "labourSource")
    private List<LabourTurnover> labourTurnoverList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "labourSource")
    private List<Employee> employeeList;

    @JsonView(LabourSourceView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
