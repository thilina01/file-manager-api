package com.trendsmixed.fma.module.productionemployee;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.employee.Employee;
import com.trendsmixed.fma.module.production.Production;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "production_employee")
public class ProductionEmployee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ProductionEmployeeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ProductionEmployeeView.Production.class)
    @JoinColumn(name = "production_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Production production;
    @JsonView(ProductionEmployeeView.Employee.class)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employee;

}
