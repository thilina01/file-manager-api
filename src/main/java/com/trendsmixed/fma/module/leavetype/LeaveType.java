package com.trendsmixed.fma.module.leavetype;

import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import javax.persistence.Table;
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
@Table(name = "leave_type")
public class LeaveType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(LeaveTypeView.Id.class)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JsonView(LeaveTypeView.Code.class)
    @Column(name = "code", length = 45, unique = true)
    private String code;
    @JsonView(LeaveTypeView.Name.class)
    @Column(name = "name", length = 250)
    private String name;
    @JsonView(LeaveTypeView.TypeInSinhala.class)
    @Column(name = "type_in_sinhala", length = 250)
    private String typeInSinhala;

}
