/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.computer;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.computertype.ComputerType;
import com.trendsmixed.fma.module.employee.Employee;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "computer")
@NamedQueries({
    @NamedQuery(name = "Computer.findAll", query = "SELECT c FROM Computer c")})
public class Computer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ComputerView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ComputerView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(ComputerView.Brand.class)
    @Column(name = "brand")
    private String brand;
    @JsonView(ComputerView.Model.class)
    @Column(name = "model")
    private String model;
    @JsonView(ComputerView.Ram.class)
    @Column(name = "ram")
    private String ram;
    @JsonView(ComputerView.Processor.class)
    @Column(name = "processor")
    private String processor;
    @JsonView(ComputerView.Hdd1.class)
    @Column(name = "hdd1")
    private String hdd1;
    @JsonView(ComputerView.Hdd2.class)
    @Column(name = "hdd2")
    private String hdd2;
    @JsonView(ComputerView.LanMac.class)
    @Column(name = "lan_mac")
    private String lanMac;
    @JsonView(ComputerView.WlanMac.class)
    @Column(name = "wlan_mac")
    private String wlanMac;
    @JsonView(ComputerView.LanIp.class)
    @Column(name = "lan_ip")
    private String lanIp;
    @JsonView(ComputerView.WlanIp.class)
    @Column(name = "wlan_ip")
    private String wlanIp;
    @JsonView(ComputerView.Value.class)
    @Column(name = "value")
    private String value;
    @JsonView(ComputerView.PurchaseDate.class)
    @Column(name = "purchase_date")
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
    @JsonView(ComputerView.TransferDate.class)
    @Column(name = "transfer_date")
    @Temporal(TemporalType.DATE)
    private Date transferDate;
    @JsonView(ComputerView.Employee.class)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Employee employee;
    @JsonView(ComputerView.ComputerType.class)
    @JoinColumn(name = "computer_type_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private ComputerType computerType;
    
    

}
