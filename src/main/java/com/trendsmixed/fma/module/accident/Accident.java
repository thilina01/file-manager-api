package com.trendsmixed.fma.module.accident;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.accidenttype.AccidentType;
import com.trendsmixed.fma.module.employee.Employee;
import com.trendsmixed.fma.module.machine.Machine;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.shift.Shift;
import com.trendsmixed.fma.module.treatment.Treatment;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
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
@Table(name = "accident")
public class Accident implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(AccidentView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(AccidentView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(AccidentView.ReferenceNo.class)
    @Column(name = "reference_no")
    private String referenceNo;
    @JsonView(AccidentView.RootCause.class)
    @Column(name = "root_cause")
    private String rootCause;
    @JsonView(AccidentView.CorrectiveAction.class)
    @Column(name = "corrective_action")
    private String correctiveAction;
    @JsonView(AccidentView.ResponsiblePerson.class)
    @Column(name = "responsible_person")
    private String responsiblePerson;
    @JsonView(AccidentView.AccidentDate.class)
    @Column(name = "accident_date")
    private Date accidentDate;
    @JsonView(AccidentView.AccidentType.class)
    @JoinColumn(name = "accident_type_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private AccidentType accidentType;
    @JsonView(AccidentView.Employee.class)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Employee employee;
    @JsonView(AccidentView.Machine.class)
    @JoinColumn(name = "machine_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Machine machine;
    @JsonView(AccidentView.Section.class)
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Section section;
    @JsonView(AccidentView.Shift.class)
    @JoinColumn(name = "shift_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Shift shift;
    @JsonView(AccidentView.Treatment.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "accident")
    private List<Treatment> treatmentList;

}
