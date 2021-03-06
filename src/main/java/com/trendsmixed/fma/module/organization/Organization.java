package com.trendsmixed.fma.module.organization;

import com.fasterxml.jackson.annotation.JsonView;
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
@Table(name = "organization")
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(OrganizationView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(OrganizationView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(OrganizationView.Name.class)
    @Column(name = "name", unique = true)
    private String name;
    @JsonView(OrganizationView.Slogan1.class)
    @Column(name = "slogan1", unique = true)
    private String slogan1;
    @JsonView(OrganizationView.Slogan2.class)
    @Column(name = "slogan2", unique = true)
    private String slogan2;
    @JsonView(OrganizationView.Vat.class)
    @Column(name = "vat", unique = true)
    private String vat;
    @JsonView(OrganizationView.Svat.class)
    @Column(name = "svat", unique = true)
    private String svat;
    @JsonView(OrganizationView.Address1.class)
    @Column(name = "address1", unique = true)
    private String address1;
    @JsonView(OrganizationView.Address2.class)
    @Column(name = "address2", unique = true)
    private String address2;
    @JsonView(OrganizationView.Address3.class)
    @Column(name = "address3", unique = true)
    private String address3;
    @JsonView(OrganizationView.Address4.class)
    @Column(name = "address4", unique = true)
    private String address4;
    @JsonView(OrganizationView.Address5.class)
    @Column(name = "address5", unique = true)
    private String address5;

}
