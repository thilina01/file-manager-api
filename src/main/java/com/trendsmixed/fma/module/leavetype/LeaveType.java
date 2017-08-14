/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.leavetype;

import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "leave_type")
@NamedQueries({
    @NamedQuery(name = "LeaveType.findAll", query = "SELECT l FROM LeaveType l")})
public class LeaveType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(LeaveTypeView.Id.class)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JsonView(LeaveTypeView.Code.class)
    @Column(name = "code", length = 45,unique=true)
    private String code;
    @JsonView(LeaveTypeView.Name.class)
    @Column(name = "name", length = 250)
    private String name;
    @JsonView(LeaveTypeView.TypeInSinhala.class)
    @Column(name = "type_in_sinhala", length = 250)
    private String typeInSinhala;

}
