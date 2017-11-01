package com.trendsmixed.fma.module.department;

import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
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
@Table(name = "department")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(DepartmentView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(DepartmentView.Code.class)
    @Column(name = "code")
    private String code;
    @JsonView(DepartmentView.Name.class)
    @Column(name = "name")
    private String name;

    @JsonView(DepartmentView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
