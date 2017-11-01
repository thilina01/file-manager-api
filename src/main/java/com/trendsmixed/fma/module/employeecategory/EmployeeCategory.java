package com.trendsmixed.fma.module.employeecategory;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.employee.Employee;
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
public class EmployeeCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(EmployeeCategoryView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(EmployeeCategoryView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(EmployeeCategoryView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "employeeCategory")
    private List<Employee> employeeList;
    @JsonView(EmployeeCategoryView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
