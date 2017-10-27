package com.trendsmixed.fma.module.employee;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.accident.Accident;
import com.trendsmixed.fma.module.computer.Computer;
import com.trendsmixed.fma.module.designation.Designation;
import com.trendsmixed.fma.module.dispatchnote.DispatchNote;
import com.trendsmixed.fma.module.employeecategory.EmployeeCategory;
import com.trendsmixed.fma.module.labourtursource.LabourSource;
import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.shift.Shift;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "employee")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT c FROM Employee c")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(EmployeeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(EmployeeView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(EmployeeView.FullName.class)
    @Column(name = "full_name")
    private String fullName;
    @JsonView(EmployeeView.FirstName.class)
    @Column(name = "first_name")
    private String firstName;
    @JsonView(EmployeeView.LastName.class)
    @Column(name = "last_name")
    private String lastName;
    @JsonView(EmployeeView.CallingName.class)
    @Column(name = "calling_name")
    private String callingName;
    @JsonView(EmployeeView.DateOfBirth.class)
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @JsonView(EmployeeView.ContactNumber.class)
    @Column(name = "contact_number")
    private String contactNumber;
    @JsonView(EmployeeView.NIC.class)
    @Column(name = "nic")
    private String nic;
    @JsonView(EmployeeView.DispatchNote.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "employee")
    private List<DispatchNote> dispatchNoteList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "employee")
    private List<Computer> computerList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "employee")
    private List<Accident> accidentList;
    @JsonView(EmployeeView.Designation.class)
    @JoinColumn(name = "designation_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Designation designation;
    @JsonView(EmployeeView.EmployeeCategory.class)
    @JoinColumn(name = "employee_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmployeeCategory employeeCategory;
    @JsonView(EmployeeView.Shift.class)
    @JoinColumn(name = "shift_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Shift shift;
    @JsonView(EmployeeView.Section.class)
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Section section;
    @JsonView(EmployeeView.LabourSource.class)
    @JoinColumn(name = "labourSource_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LabourSource labourSource;
}
