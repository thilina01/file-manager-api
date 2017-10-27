package com.trendsmixed.fma.module.shift;

import com.trendsmixed.fma.module.production.Production;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.accident.Accident;
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
@Table(name = "shift")
public class Shift implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ShiftView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ShiftView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(ShiftView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "shift")
    private List<Production> productionList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "shift")
    private List<Accident> accidentList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "shift")
    private List<Employee> employeeList;

    public Shift(Integer id) {
        this.id = id;
    }

}
