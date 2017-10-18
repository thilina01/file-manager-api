package com.trendsmixed.fma.module.organization;

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
@Table(name = "organization")
@NamedQueries({
    @NamedQuery(name = "Organization.findAll", query = "SELECT c FROM Organization c")})
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

}
