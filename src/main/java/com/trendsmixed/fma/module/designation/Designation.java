package com.trendsmixed.fma.module.designation;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.employee.Employee;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "designation")
@NamedQueries({
    @NamedQuery(name = "Designation.findAll", query = "SELECT i FROM Designation i")})
public class Designation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(DesignationView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(DesignationView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(DesignationView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "designation")
    private List<Employee> employeeList;

}