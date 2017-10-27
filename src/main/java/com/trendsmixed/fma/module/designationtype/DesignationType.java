package com.trendsmixed.fma.module.designationtype;

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
@Table(name = "designation_type")
@NamedQueries({
    @NamedQuery(name = "DesignationType.findAll", query = "SELECT i FROM DesignationType i")})
public class DesignationType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(DesignationTypeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(DesignationTypeView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(DesignationTypeView.Name.class)
    @Column(name = "name")
    private String name;

}
