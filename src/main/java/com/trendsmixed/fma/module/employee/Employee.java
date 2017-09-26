/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.employee;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.accident.Accident;
import com.trendsmixed.fma.module.computer.Computer;
import com.trendsmixed.fma.module.dispatchnote.DispatchNote;
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
    @JsonView(EmployeeView.FirstName.class)
    @Column(name = "first_name")
    private String firstName;
    @JsonView(EmployeeView.LastName.class)
    @Column(name = "last_name")
    private String lastName;
    @JsonView(EmployeeView.DateOfBirth.class)
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @JsonView(EmployeeView.ContactNumber.class)
    @Column(name = "contact_number")
    private String contactNumber;
    @JsonView(EmployeeView.Address.class)
    @Column(name = "address")
    private String address;
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

}
